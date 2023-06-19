package week5.thread;

public class TestRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("$");
        }
    }
}
