package task3;

import java.util.Random;

public class ThreadToPeek implements Runnable{
    private SynchronizedStack stack;
    private int peekTimes;

    public ThreadToPeek(SynchronizedStack stack, int peekTimes) {
        this.stack = stack;
        this.peekTimes = peekTimes;
    }

    public void run() {
        Thread.currentThread().setName("ThreadToPeek");
        for (int i = 0; i < peekTimes; i++)
            System.out.println("peek: " + stack.peek());
    }
}
