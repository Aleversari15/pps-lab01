package tdd;

import java.util.List;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {

    /**
     * Add element to the queue.
     * When full, new element overwrite the oldest one.
     */
    void enqueue(int value);

    /**
     * Remove from the queue the oldest element.
     *
     * @return The element removed
     * @throws IllegalStateException if the queue is empty
     */
    int dequeue();

    /**
     * Retrieves the capacity of the queue.
     *
     * @return The capacity of the queue
     */
    int getCapacity();

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Retrieve a copy of the queue.
     *
     * @return A copy of the queue
     */
    List<Integer> getQueue();


}