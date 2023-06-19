package week5.thread.stat.sleep;

public class Main {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                // (1) 예외처리 필수
                // - interrupt() 를 만나면 다시 실행되기 때문에
                // - InterruptException이 발생할 수 있다.
                // (2) 특정 쓰레드 지목 불가
                Thread.sleep(2000); // TIMED_WAITTING(주어진 시간동안만 기다리는 상태)

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task : " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(task, "Thread");
        thread.start(); // NEW -> RUNNABLE

        try {
            // 1초가 지나고 나면 runnable 상태로 변하여 다시 실행
            // 특정 스레드를 지목해서 멈추게 하는 것은 불가능
            // Static member 'java.lang.Thread.sleep(long)' accessed via instance reference
            // 변수 thread를 지칭해서 sleep을 해도 의미가 없다고 나온다.
            thread.sleep(1000);
            System.out.println("sleep(1000) : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
