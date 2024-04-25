package javaconcepts.multithreading.raceCondition;
public class RaceConditionExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Create two threads that concurrently increment and decrement the counter
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
                System.out.println("in incre "+counter.getCount());
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.decrement();System.out.println("in decre "+counter.getCount());
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
        System.out.println("Final Count: " + counter.getCount());
    }
}

class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}
