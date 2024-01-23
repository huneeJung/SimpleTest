import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ThreadPoolTest {
    private static final Logger LOG = Logger.getLogger("ThreadPoolTest");

    public static void main(String[] args) throws InterruptedException {
        // 쓰레드 풀 처리
        Instant before = Instant.now();
        ExecutorService threadPool = Executors.newFixedThreadPool(1000);
        for(int i = 0 ; i < 10000 ; i++){
            Runnable worker = new Processor("Task No : " + i);
            threadPool.execute(worker);
        }
        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.MINUTES);
        Instant after = Instant.now();
        LOG.info("Thread Pool Time ::: "+Duration.between(before,after).toMillis());

        // 개별 쓰레드 처리
        Instant before2 = Instant.now();
        Thread[] threads = new Thread[10000];
        for(int i = 0 ; i < 10000 ; i++){
            threads[i] = new Thread(new Processor("Task No : " + i));
            threads[i].start();
        }
        for(int i = 0 ; i < 10000 ; i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Instant after2 = Instant.now();
        LOG.info("Thread Time ::: "+Duration.between(before2,after2).toMillis());
    }

    public static class Processor implements Runnable{
        private String taskName;
        public Processor(String taskName) {
            this.taskName = taskName;
        }
        @Override
        public void run() {
        }
    }

}
