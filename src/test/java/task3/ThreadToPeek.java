package task3;

public class ThreadToPeek implements Runnable{
    private Stack stack;
    private int peekTimes;

    public ThreadToPeek(Stack stack, int peekTimes) {
        this.stack = stack;
        this.peekTimes = peekTimes;
    }

    public void run() {
        Thread.currentThread().setName("ThreadToPeek");
        for (int i = 0; i < peekTimes; i++) {
            System.out.println("peek: " + stack.peek());
        }
    }
}
