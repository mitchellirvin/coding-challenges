import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MultiThreadingDemo {
    // really wordy way of doing what the lambda in main() does
    static class RunDemo implements Runnable {
        private String threadName;

        RunDemo(String threadName) {
            this.threadName = threadName;
        }

        public void run() {
            System.out.println("Running " +  threadName);
        }
    }

    public static void basicThread() {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Thread: " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        // or:
        // Thread thread = new Thread(new RunDemo("myThread"));
        thread.start();
        try {
            thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted!");
        }
    }

    public static void multiThread() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        Future<Integer> future = executor.submit(task);
        System.out.println("future done: " + future.isDone());

        try {
            Integer result = future.get();
            System.out.println("future done: " + future.isDone());
            System.out.print("result: " + result);
        } catch (Exception e) {
            System.out.println("Interrupted");
        }

        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("executor tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

    public static void main(String[] args) {
        // basicThread();

        // multiThread();
        //Get ExecutorService from Executors utility class, thread pool size is 10
        ExecutorService executor = Executors.newFixedThreadPool(10);

        //create a list to hold the Future object associated with Callable
        List<Future<String>> futures = new ArrayList<Future<String>>();
        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("task1");
        tasks.add("task2");
        tasks.add("task3");
        tasks.add("task4");
        tasks.add("task5");

        //Create MyCallable instance
        for(String task : tasks){
            //submit Callable tasks to be executed by thread pool
            Future<String> future = executor.submit(() -> {
                return task;
            });
            // add Future to the list, we can get return value using Future
            futures.add(future);
        }

        for(Future<String> future : futures) {
            try {
                System.out.println(new Date() + "::" + future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        executor.shutdown();

        System.out.println("Done!");
    }
}
