package week5.thread.stat.interrupt;

/*public class Main {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                // sleep 도중 interrupt 발생 시 , catch
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task : " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(task, "Thread");
        thread.start();

        thread.interrupt();

        System.out.println("thread.isInterrupted() = " + thread.isInterrupted());

    }
}*/

public class Main {
    public static void main(String[] args) {
        Runnable task = () -> {
            // 쓰레드 상태 체크 interrupt 되기 전엔 계속 실행 한다.
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("도달했다.");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("task : " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(task, "Thread");
        thread.start();

        thread.interrupt();

        System.out.println("thread.isInterrupted() = " + thread.isInterrupted());

    }
}
