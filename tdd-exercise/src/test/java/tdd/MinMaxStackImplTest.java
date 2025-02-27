package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Console;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    private static final int TEST_VALUE = 1;
    private MinMaxStack stack;

    @BeforeEach
    void beforeEach() {
        this.stack = new MinMaxStackImpl();
    }
    @Test
    public void testPush() {
        this.stack.push(TEST_VALUE);
        assertFalse(this.stack.isEmpty());
    }

    @Test
    public void testPop() {
        this.stack.push(TEST_VALUE);
        int oldSize = this.stack.size();
        int value = this.stack.pop();
        assertEquals(0,this.stack.size());
        assertEquals(TEST_VALUE, value);
    }

    @Test
    public void testPeek() {
        this.stack.push(TEST_VALUE);
        int oldSize = this.stack.size();
        int value = this.stack.peek();
        assertEquals(TEST_VALUE, value);
        assertEquals(oldSize, this.stack.size());
    }
}