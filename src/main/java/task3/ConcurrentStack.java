package task3;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentStack implements Stack {
    private int size;
    private LinkedList stack;

    public ConcurrentStack(int size) {
        this.size = size;
        this.stack = new LinkedList<Integer>();
    }

    public void push(Integer i) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        lock.lock();
        try {
            while (getSize() > size) {
                condition.await();
            }
            stack.addLast(i);
            condition.signal();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public Integer pop() {
        Integer popped = null;
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        lock.lock();
        try {
            while ((getSize() == 0)) {
                condition.await();
            }
            popped = (Integer) stack.removeLast();
            condition.signal();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
            return popped;
        }
    }

    public Integer peek() {
        Integer peeked = null;
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        lock.lock();
        try {
            while ((getSize() == 0)) {
                condition.await();
            }
            peeked = (Integer) stack.getLast();
            condition.signal();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
            return peeked;
        }
    }

    public int getSize() {
        Lock lock = new ReentrantLock();
        lock.lock();
        int size;
        try {
            size = stack.size();
        } finally {
            lock.unlock();
        }
        return size;
    }

}
