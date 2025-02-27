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
        if(!this.stack.isEmpty()){
            return this.stack.remove(stack.size()-1);
        }else{
            throw new IllegalStateException();
        }
    }

    @Override
    public int peek() {
        if(!this.stack.isEmpty()){
            return this.stack.get(stack.size()-1);
        }else{
            throw new IllegalStateException();
        }
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
