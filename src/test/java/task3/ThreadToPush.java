package task3;

import java.util.Random;

public class ThreadToPush implements Runnable {
    private Stack stack;
    private int pushTimes;

    public ThreadToPush(Stack stack, int pushTimes) {
        this.stack = stack;
        this.pushTimes = pushTimes;
    }

    public void run() {
        Thread.currentThread().setName("ThreadToPush");
        for (int i = 0; i < pushTimes; i++) {
            Integer intToPush = new Random().nextInt();
            System.out.println("push: "+intToPush);
            stack.push(intToPush);
        }
    }
}
