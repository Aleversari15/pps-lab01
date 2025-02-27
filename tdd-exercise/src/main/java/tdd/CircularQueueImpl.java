package tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CircularQueueImpl implements CircularQueue{
    private final int capacity;
    private final List<Integer> queue;
    private int queuedElements;

    public CircularQueueImpl(int capacity){
        this.capacity = capacity;
        this.queue = new ArrayList<>();
        this.queuedElements = 0;
    }

    @Override
    public void enqueue(int value) {
        this.queuedElements++;
        if(this.queuedElements<= this.capacity){
            this.queue.add(value);
        }
        else{
            queue.set(getOldestElementPosition(), value);
        }
    }

    @Override
    public int dequeue() {
        if(!isEmpty()){
            int pos = getOldestElementPosition();
            this.queuedElements--;
            return queue.remove(pos);
        }
        else{
            throw new IllegalStateException();
        }
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public List<Integer> getQueue() {
        return Collections.unmodifiableList(this.queue);
    }

    private int getOldestElementPosition(){
        return ((queuedElements%capacity)-1);
    }
}
