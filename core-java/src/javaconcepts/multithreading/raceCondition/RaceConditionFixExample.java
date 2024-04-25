package javaconcepts.multithreading.raceCondition;

class NewCounter {
    private int count = 0;
    // Synchronize the increment method
    public synchronized void increment() {
        count++;
    }

    // Synchronize the decrement method
    public synchronized void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}

public class RaceConditionFixExample {
    public static void main(String[] args) {
        NewCounter NewCounter = new NewCounter();

        // Create two threads that concurrently increment and decrement the NewCounter
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                NewCounter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                NewCounter.decrement();
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final count
        System.out.println("Final Count: " + NewCounter.getCount());
    }
}

