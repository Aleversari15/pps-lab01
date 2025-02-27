package tdd;

import java.util.ArrayList;
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
            int posToOverwrite = (queuedElements%capacity)-1;
            queue.set(posToOverwrite, value);
        }
    }

    @Override
    public int dequeue() {
        int posElementToRemove = queuedElements%capacity;
        this.queuedElements--;
        return queue.remove(posElementToRemove);

    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
}
