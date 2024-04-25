package javaconcepts.multithreading;
public class MonitorExample {
    private final Object monitor = new Object();
    private boolean condition = false;
    public void waitForCondition() throws InterruptedException {
        synchronized (monitor) {
            while (!condition) {
                monitor.wait(); // Wait until condition becomes true
            }
            System.out.println("Condition is now true, continuing execution...");
        }
    }

    public void setConditionTrue() {
        synchronized (monitor) {
            condition = true;
            monitor.notify(); // Signal one waiting thread
            // or use monitor.notifyAll() to signal all waiting threads
            System.out.println("Condition set to true, notifying waiting thread...");
        }
    }

    public static void main(String[] args) {
        MonitorExample example = new MonitorExample();

        // Thread to wait for condition
        Thread waitingThread = new Thread(() -> {
            try {
                System.out.println("Waiting for condition to become true...");
                example.waitForCondition();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Thread to set condition to true after a delay
        Thread settingThread = new Thread(() -> {
            try {
                // Simulate some delay before setting the condition to true
                Thread.sleep(2000);
                example.setConditionTrue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start both threads
        waitingThread.start();
        settingThread.start();
    }
}
