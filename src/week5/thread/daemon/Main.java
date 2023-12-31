package week5.thread.daemon;

public class Main {
    public static void main(String[] args) {
        Runnable daemon = () -> {
            for (int i = 0; i < 1000000; i++) {
                System.out.println("daemon");
            }
        };

        // 우선순위가 낮다 => 상대적으로 다른 쓰레드에 비해 리소스를 적게 할당 받음
        Thread thread = new Thread(daemon);
        thread.setDaemon(true);

        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("task");
        }
    }
}
