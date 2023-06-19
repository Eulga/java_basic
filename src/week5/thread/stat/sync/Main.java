package week5.thread.stat.sync;

public class Main {
    public static void main(String[] args) {
        AppleStore appleStore = new AppleStore();

        Runnable task = () -> {
            while (appleStore.getStoredApple() > 0) {
                appleStore.eatApple();
                System.out.println("남은 사과의 수 = " + appleStore.getStoredApple());
            }

        };

        // 3개의 thread를 한꺼번에 만들어서 start를 해버림
        // 생성과 동시에 start(NEW -> RUNNABLE)
        for (int i = 0; i < 3; i++) {
            new Thread(task, "thread" + i).start();
        }
    }
}

class AppleStore {
    private int storedApple = 10;

    public int getStoredApple() {
        return storedApple;
    }

    public void eatApple() {
        // 한 쓰레드가 이 코드를 점유하기 때문에 다른 스레드는 대기해야함
        synchronized (this) {
            if (storedApple > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                storedApple -= 1;
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
