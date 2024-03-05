package lambda;

public class RunnableExample {
    public static void main(String[] args) {
        //Before Java8
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("run() from runnable");
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();


        //After Java8
        //Here notice that, runnable1 itself hold the implementation of single method that Runnable holds
        Runnable runnable1 = () ->
            System.out.println("this is new way to implement runnable");
        new Thread(runnable1).start();


        //Another way that we want to pass Runnable implementation directly to the Thread
        //As Thread is looking for Runnable Interface implementation, it knows that given implementation is for same
        new Thread(
                () -> System.out.println("another way to use Runnable in Thread directly")
        ).start();

    }

}
