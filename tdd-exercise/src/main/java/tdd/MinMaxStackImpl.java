package tdd;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl implements  MinMaxStack{
    private final List<Integer> stack = new ArrayList<>();

    @Override
    public void push(int value) {
        this.stack.add(value);
    }

    @Override
    public int pop() {
        if(!isEmpty()){
            return this.stack.remove(stack.size()-1);
        }else{
            throw new IllegalStateException();
        }
    }

    @Override
    public int peek() {
        if(!isEmpty()){
            return this.stack.get(stack.size()-1);
        }else{
            throw new IllegalStateException();
        }
    }

    @Override
    public int getMin() {
        if(!isEmpty()){
            int min = this.stack.get(0);
            for (Integer val : this.stack) {
                if (val < min)
                    min = val;
            }
            return min;
        }
        else{
            throw new IllegalStateException();
        }
    }

    @Override
    public int getMax() {
        if (!isEmpty()) {
            int max = this.stack.get(0);
            for (Integer val : this.stack) {
                if (val > max)
                    max = val;
            }
            return max;
        }
        else{
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }
}
