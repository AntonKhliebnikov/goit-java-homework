package module12;


import java.util.concurrent.*;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        Runnable producer = new Runnable() {
            int counter;
            @Override
            public void run() {
                try {
                    queue.put(counter);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                counter++;
                System.out.println(counter);
            }
        };

        Runnable consumer = () -> {
            System.out.println("5 seconds passed");
            while (!queue.isEmpty()) {
                queue.poll();
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(producer, 1, 1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(consumer, 5, 5, TimeUnit.SECONDS);

        Thread.sleep(20000);
        executor.shutdown();
    }
}


