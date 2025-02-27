package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private static final int CAPACITY = 3;
    private static final int FIRST_VALUE = 1;
    private static final int SECOND_VALUE = 2;
    private static final int THIRD_VALUE = 3;
    private static final int FOURTH_VALUE = 4;
    private CircularQueue queue;

    @BeforeEach
    public void beforeEach() {
        this.queue = new CircularQueueImpl(CAPACITY);
    }

    @Test
    public void testEnqueueNotFullList() {
        this.queue.enqueue(FIRST_VALUE);
        assertTrue(this.queue.getQueue().contains(FIRST_VALUE));
        assertFalse(this.queue.isEmpty());
    }

    @Test
    public void testEnqueueWithFullList() {
        this.queue.enqueue(FIRST_VALUE);
        this.queue.enqueue(SECOND_VALUE);
        this.queue.enqueue(THIRD_VALUE);
        this.queue.enqueue(FOURTH_VALUE);
        assertTrue(this.queue.getQueue().contains(FOURTH_VALUE));
        assertFalse(this.queue.getQueue().contains(FIRST_VALUE));
        assertEquals(CAPACITY, this.queue.getQueue().size());
    }

    @Test
    public void testDequeue() {
        this.queue.enqueue(FIRST_VALUE);
        int oldSize = this.queue.getQueue().size();
        int valueRemoved = this.queue.dequeue();
        assertEquals(FIRST_VALUE,valueRemoved);
        assertEquals(oldSize-1, this.queue.getQueue().size());
    }

    @Test
    void testDequeueWithEmptyStack() {
        assertThrows(IllegalStateException.class, () -> queue.dequeue());
    }
}
