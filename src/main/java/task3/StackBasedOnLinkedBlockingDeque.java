package task3;

import java.util.concurrent.LinkedBlockingDeque;

public class StackBasedOnLinkedBlockingDeque implements Stack {

    private LinkedBlockingDeque<Integer> stack;
    private int size;

    public StackBasedOnLinkedBlockingDeque(int size) {
        this.size = size;
        stack = new LinkedBlockingDeque<>(size);
    }

    @Override
    public void push(Integer i) {
        try {
            stack.put(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer pop() {
        Integer popped = null;
        try {
            popped = stack.takeLast();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return popped;
    }

    @Override
    public Integer peek() {
      throw new UnsupportedOperationException();
    }

    @Override
    public int getSize() {
        return stack.size();
    }
}
