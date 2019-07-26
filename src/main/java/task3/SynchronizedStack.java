package task3;

import java.util.LinkedList;
import java.util.List;

public class SynchronizedStack {
    private int size;
    private int headIndex;
    private LinkedList stack;

    public SynchronizedStack(int size) {
        this.size = size;
        this.stack = new LinkedList<Integer>();
    }

    synchronized public void push(Integer i) {
        while (headIndex==size) {
            try {
                wait();
                System.out.println("thread " + Thread.currentThread().getName() + " wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stack.addLast(i);
        headIndex++;
        notify();
    }

    synchronized public Integer pop() {
        while (stack.isEmpty()) {
            try {
                wait();
                System.out.println("thread " + Thread.currentThread().getName() + " wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Integer poppedInt = (Integer) stack.removeLast();
        headIndex--;
        notify();
        return poppedInt;
    }

    synchronized public Integer peek() {
        while (stack.isEmpty()) {
            try {
                wait();
                System.out.println("thread " + Thread.currentThread().getName() + " wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Integer poppedInt = (Integer) stack.getLast();
        notify();
        return poppedInt;
    }

    public int getSize(){
        return stack.size();
    }
}
