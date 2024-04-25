package javaconcepts.multithreading.waysToCreateThread;

public class MultiThread1 extends Thread {

    @Override
    public void run() {
        System.out.println("do Something");
    }
    public static void main(String[] args) {
        Thread t1 = new MultiThread1();
        t1.start();

    }
}
