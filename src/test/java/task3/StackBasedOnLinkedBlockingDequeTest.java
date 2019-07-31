package task3;

import org.junit.Test;

public class StackBasedOnLinkedBlockingDequeTest {
    @Test
    public void stackTest1() {
        StackBasedOnLinkedBlockingDeque stack = new StackBasedOnLinkedBlockingDeque(6);

        ThreadToPush threadToPush = new ThreadToPush(stack, 10);
        ThreadToPop threadToPop = new ThreadToPop(stack, 6);

        Thread threadPush = new Thread(threadToPush);
        Thread threadPop = new Thread(threadToPop);

        threadPush.start();
        threadPop.start();
        try {
            threadPush.join();
            threadPop.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert (stack.getSize() == 4);
    }

    @Test
    public void stackTest2() {
        StackBasedOnLinkedBlockingDeque stack = new StackBasedOnLinkedBlockingDeque(6);

        ThreadToPush threadToPush = new ThreadToPush(stack, 10);
        ThreadToPop threadToPop = new ThreadToPop(stack, 10);

        Thread threadPush = new Thread(threadToPush);
        Thread threadPop = new Thread(threadToPop);

        threadPush.start();
        threadPop.start();
        try {
            threadPush.join();
            threadPop.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert (stack.getSize() == 0);
    }

}
