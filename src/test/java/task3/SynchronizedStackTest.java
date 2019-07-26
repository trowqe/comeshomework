package task3;


import org.junit.Test;

public class SynchronizedStackTest {

    @Test
    public void synchronizedStackTestPop(){
        SynchronizedStack stack = new SynchronizedStack(10);

        ThreadToPop threadToPop = new ThreadToPop(stack, 20);
        ThreadToPush threadToPush = new ThreadToPush(stack, 20);

        Thread thread1 = new Thread(threadToPop);
        Thread thread2 = new Thread(threadToPush);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assert(stack.getSize() == 0);
    }

    @Test
    public void synchronizedStackTestPeek(){
        SynchronizedStack stack = new SynchronizedStack(20);

        ThreadToPeek threadToPeek = new ThreadToPeek(stack, 20);
        ThreadToPush threadToPush = new ThreadToPush(stack, 20);

        Thread thread1 = new Thread(threadToPeek);
        Thread thread2 = new Thread(threadToPush);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert(stack.getSize() == 20);
    }


}
