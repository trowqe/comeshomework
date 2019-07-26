package task3;

import java.util.LinkedList;
import java.util.List;

public class SynchronizedStack {
    private int size;
    private int top;
    private int bottom;
    private List stack;

    public SynchronizedStack(int size) {
        this.size = size;
        this.bottom = 0;
        this.top = 0;
        this.stack = new LinkedList<Integer>();
    }

    synchronized public void push(Integer i) {
        while (bottom == size) {
            try {
                wait();
                System.out.println("thread " + Thread.currentThread().getName()+" wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stack.add(top, i);
        top++;
        notify();
    }

    synchronized public Integer pop() {
        while (top == bottom) {
            try {
                wait();
                System.out.println("thread " + Thread.currentThread().getName()+" wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Integer poppedInt = (Integer) stack.remove(top);
        top--;
        notify();
        return poppedInt;
    }

    synchronized public Integer peek() {
        while (top == bottom && isEmpty()) {
            try {
                wait();
                System.out.println("thread " + Thread.currentThread().getName()+" wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Integer poppedInt = (Integer) stack.get(top);
        top--;
        notify();
        return poppedInt;
    }

    synchronized public boolean isEmpty() {
        return stack.isEmpty();
    }


}
