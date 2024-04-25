package javaconcepts.multithreading.waysToCreateThread;

public class MultiThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("do something new");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MultiThread2());
        t1.start();
    }
}
