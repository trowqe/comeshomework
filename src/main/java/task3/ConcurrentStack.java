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
            while (getSize() == size) {
                condition.await();
            }
            stack.addLast(i);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
            condition.signal();
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
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
            condition.signal();
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
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
            condition.signal();
            return peeked;
        }
    }

    public int getSize() {
        return stack.size();
    }
}
