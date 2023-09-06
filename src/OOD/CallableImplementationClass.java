package OOD;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CallableImplementationClass implements Callable {

    @Override
    public Object call() throws Exception {
        return null;
    }
        public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> stringCallable = () -> {
            Thread.sleep(1000);
            return "hello edpresso";
        };
        Future<String> stringFuture = executorService.submit(stringCallable);
        String res = stringFuture.get();
//        while(!stringFuture.isDone() && !stringFuture.isCancelled()) {
//            Thread.sleep(200);
//            System.out.println("Waiting for task completion...");
//        }
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
            executor.submit(() -> {
                Thread.sleep(1000);
                return null;
            });
            executor.submit(() -> {
                Thread.sleep(1000);
                return null;
            });
            executor.submit(() -> {
                Thread.sleep(1000);
                return null;
            });

            assertEquals(2, executor.getPoolSize());
            assertEquals(1, executor.getQueue().size());

        String result = stringFuture.get();

        System.out.println("Retrieved result from the task - " + result);

        executorService.shutdown();
    }
}
