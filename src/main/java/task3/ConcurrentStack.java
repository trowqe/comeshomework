package task3;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentStack implements Stack{
    private int size;
    private LinkedList stack;

    public ConcurrentStack(int size) {
        this.size = size;
        this.stack = new LinkedList<Integer>();
    }

     public void push(Integer i) {
        Lock lock = new ReentrantLock();
            lock.lock();
            try {
                // весьма сомнительно
                while((getSize()==size)){

                }
                stack.addLast(i);
            } finally {
                lock.unlock();
            }
    }

    public Integer pop() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            while((getSize()==0)){

            }
            return (Integer) stack.removeLast();
        } finally {
            lock.unlock();
        }
    }

    public Integer peek() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            while((getSize()==0)){

            }
            return  (Integer) stack.getLast();
        } finally {
            lock.unlock();
        }
    }

    public int getSize() {
        return stack.size();
    }
}
