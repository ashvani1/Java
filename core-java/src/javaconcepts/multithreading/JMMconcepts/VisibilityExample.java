package javaconcepts.multithreading.JMMconcepts;

public class  VisibilityExample {
    private static volatile boolean flag = false;
    public static void main(String[] args) {
        // Thread 1: Updates the flag
        Thread thread1 = new Thread(() -> {
            flag = true;
        });
        thread1.start();

        // Thread 2: Reads the flag
        Thread thread2 = new Thread(() -> {
            while (!flag) {
                // Wait until flag is true
            }
            System.out.println("Flag is true");
        });
        thread2.start();
    }
}
// without the volatile keyword, there is no guarantee that the update made by Thread 1 to the flag variable will be
// visible to Thread 2.

