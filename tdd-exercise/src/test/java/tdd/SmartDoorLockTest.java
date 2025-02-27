package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private static final int PIN = 1234;
    private static final int WRONG_PIN=1111;
    private SmartDoorLock lock;


    @BeforeEach
    void beforeEach() {
        this.lock = new SmartDoorLockImpl();
        this.lock.setPin(PIN);
        try{
            this.lock.lock();
        } catch (Exception e) {
        }
    }

    @Test
    public void testUnlock() {
        this.lock.unlock(PIN);
        assertFalse(this.lock.isLocked());
    }

    @Test
    public void testWrongUnlock() {
        this.lock.unlock(WRONG_PIN);
        assertTrue(this.lock.isLocked());
    }

    @Test
    public void testReset() {
        this.lock.reset();
        assertFalse(this.lock.isLocked());
        assertFalse(this.lock.isBlocked());
        assertEquals(0,this.lock.getFailedAttempts());
    }

    @Test
    public void testMaxAttempts() {
        this.lock.reset();
        this.lock.unlock(WRONG_PIN);
        this.lock.unlock(WRONG_PIN);
        this.lock.unlock(WRONG_PIN);
        assertTrue(this.lock.isBlocked());
        assertEquals(3, this.lock.getFailedAttempts());
    }
}
