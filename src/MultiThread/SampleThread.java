package MultiThread;

import org.junit.jupiter.api.Test;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SampleThread extends Thread {
    public int processingCount = 0;

    SampleThread(int processingCount) {
        this.processingCount = processingCount;
        LOGGER.info("Thread Created");
    }

    @Override
    public void run() {
//        LOGGER.info("Thread " + this.getName() + " started");
        System.out.println("Thread " + this.getName() + " started");
        while (processingCount > 0) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                LOGGER.info("Thread " + this.getName() + " interrupted");
            }
            processingCount--;
        }
        LOGGER.info("Thread " + this.getName() + " exiting");
    }

    public static void main(String[] args) {
        Thread t2 = new SampleThread(1);
        t2.start();
    }
//    @Test
//    public void givenStartedThread_whenJoinCalled_waitsTillCompletion()
//            throws InterruptedException {
//        Thread t2 = new SampleThread(1);
//        t2.start();
//        LOGGER.info("Invoking join");
//        t2.join();
//        LOGGER.info("Returned from join");
////        assertFalse(t2.isAlive());
//    }
}

