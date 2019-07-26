package task3;

public class ThreadToPop implements Runnable {
    private SynchronizedStack stack;
    private int popTimes;

    public ThreadToPop(SynchronizedStack stack, int popTimes) {
        this.stack = stack;
        this.popTimes = popTimes;
    }

    public void run() {
        Thread.currentThread().setName("ThreadToPop");
        for (int i = 0; i < popTimes; i++)
            System.out.println("pop: " + stack.pop());
    }
}
