package task3;


import org.junit.Test;

public class ConcurrentStackTest {

    /*
    @Test
    public void concurrentStackTestPop() {
        ConcurrentStack stack = new ConcurrentStack(10);

        ThreadToPop threadToPop = new ThreadToPop(stack, 10);
        ThreadToPush threadToPush = new ThreadToPush(stack, 10);

        Thread thread1 = new Thread(threadToPop);
        Thread thread2 = new Thread(threadToPush);

        System.out.println(stack.getSize());
        thread1.start();
        System.out.println(stack.getSize());
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(stack.getSize());
        assert (stack.getSize() == 0);
     }

     */
    @Test
    public void concurrentStackTestPush() {
        ConcurrentStack stack = new ConcurrentStack(10);

        ThreadToPush threadToPush = new ThreadToPush(stack, 10);

        Thread thread1 = new Thread(threadToPush);

        System.out.println(stack.getSize());
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(stack.getSize());
        assert (stack.getSize() == 10);
    }

    @Test
    public void concurrentStackTestPeek() {
        SynchronizedStack stack = new SynchronizedStack(20);

        ThreadToPeek threadToPeek = new ThreadToPeek(stack, 20);
        ThreadToPush threadToPush = new ThreadToPush(stack, 20);
        ThreadToPop threadToPop = new ThreadToPop(stack, 20);

        Thread threadPeek = new Thread(threadToPeek);
        Thread threadPush = new Thread(threadToPush);
        Thread threadPop = new Thread(threadToPop);

        threadPeek.start();
        threadPush.start();
        threadPop.start();
        try {
            threadPeek.join();
            threadPush.join();
            threadPop.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert (stack.getSize() == 0);
    }


}
