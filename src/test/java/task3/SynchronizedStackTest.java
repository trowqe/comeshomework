package task3;


import org.junit.Test;

public class SynchronizedStackTest {



    public static void main(String[] args) {
        SynchronizedStack stack = new SynchronizedStack(10);

        ThreadToPop threadToPop = new ThreadToPop(stack, 20);
        ThreadToPush threadToPush = new ThreadToPush(stack, 20);
        new Thread(threadToPop).start();
        new Thread(threadToPush).start();

    }

}
