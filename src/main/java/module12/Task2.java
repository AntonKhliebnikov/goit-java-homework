package module12;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        ThreadA threadA = new ThreadA(queue);
        ThreadB threadB = new ThreadB(queue);
        ThreadC threadC = new ThreadC(queue);
        ThreadD threadD = new ThreadD(queue);

        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(threadA);
        executor.execute(threadB);
        executor.execute(threadC);
        executor.execute(threadD);

        for (int i = 1; i <= 20; i++) {
            threadA.setN(i);
            threadB.setN(i);
            threadC.setN(i);
            threadD.setN(i);

            while (threadA.isUpdated() || threadB.isUpdated() || threadC.isUpdated() || threadD.isUpdated()) {
                Thread.sleep(500);
            }
        }
        executor.shutdownNow();
    }

    public static class ThreadA implements Runnable {
        private int n;
        private boolean updated = false;
        private final BlockingQueue queue;

        public ThreadA(BlockingQueue queue) {
            this.queue = queue;
        }

        public void setN(int n) {
            this.n = n;
            updated = true;
        }

        public boolean isUpdated() {
            return updated;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    if (updated) {
                        updated = false;
                        fizz();
                    }
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        private void fizz() throws InterruptedException {
            if (n % 3 == 0 && n % 5 != 0) {
                queue.put("fizz");
            }
        }
    }

    public static class ThreadB implements Runnable {
        private int n;
        private boolean updated = false;
        private final BlockingQueue queue;

        public ThreadB(BlockingQueue queue) {
            this.queue = queue;
        }

        public void setN(int n) {
            this.n = n;
            updated = true;
        }

        public boolean isUpdated() {
            return updated;
        }


        @Override
        public void run() {
            while (true) {
                try {
                    if (updated) {
                        updated = false;
                        buzz();
                    }
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        private void buzz() throws InterruptedException {
            if (n % 5 == 0 && n % 3 != 0) {
                queue.put("buzz");
            }
        }

    }

    public static class ThreadC implements Runnable {
        private int n;
        private boolean updated = false;
        private final BlockingQueue queue;

        public ThreadC(BlockingQueue queue) {
            this.queue = queue;
        }

        public void setN(int n) {
            this.n = n;
            updated = true;
        }

        public boolean isUpdated() {
            return updated;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    if (updated) {
                        updated = false;
                        fizzbuzz();
                    }
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        private void fizzbuzz() throws InterruptedException {
            if (n % 15 == 0) {
                queue.put("fizzbuzz");
            }
        }
    }

    public static class ThreadD implements Runnable {
        private int n;
        private boolean updated = false;
        private final BlockingQueue queue;

        public ThreadD(BlockingQueue queue) {
            this.queue = queue;
        }

        public void setN(int n) {
            this.n = n;
            updated = true;
        }

        public boolean isUpdated() {
            return updated;
        }

        public void number() throws InterruptedException {
            if (n % 3 != 0 && n % 5 != 0) {
                queue.put(String.valueOf(n));
            }
        }

        @Override
        public void run() {
            while (true) {
                while (!queue.isEmpty()) {
                    System.out.print(queue.poll() + ", ");
                }
                try {
                    if (updated) {
                        updated = false;
                        number();
                    }
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

