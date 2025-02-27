package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private static final int CAPACITY = 3;
    private CircularQueue queue;

    @BeforeEach
    public void beforeEach() {
        this.queue = new CircularQueueImpl(CAPACITY);
    }


    @Test
    public void testQueue() {
        assertTrue(true);
    }

    public void testQueueWithFullList() {
        assertTrue(true);
    }

    @Test
    public void testRemove() {
        assertTrue(true);
    }

    @Test
    public void test() {
        assertTrue(true);
    }
}
