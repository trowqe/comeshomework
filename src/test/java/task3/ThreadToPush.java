package task3;

import java.util.Random;

public class ThreadToPush implements Runnable {
    private SynchronizedStack stack;
    private int pushTimes;

    public ThreadToPush(SynchronizedStack stack, int pushTimes) {
        this.stack = stack;
        this.pushTimes = pushTimes;
    }

    public void run() {
        for (int i = 0; i < pushTimes; i++) {
            Integer intToPush = new Random().nextInt();
            System.out.println("push: "+intToPush);
            stack.push(intToPush);
        }
    }
}
