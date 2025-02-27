package tdd;

public class SmartDoorLockImpl implements  SmartDoorLock{
    private static final int FAILED_ATTEMPTS_LIMIT = 3;
    private static final int NO_PIN_VALUE = -1;
    private int pinSaved = NO_PIN_VALUE;

    public enum LockStates{
        Locked,
        Unlocked,
        Open,
        Blocked
    }
    private LockStates doorState = LockStates.Open;
    private int failedAttempts = 0;

    @Override
    public void setPin(int pin) {
        if(!isLocked() && !isBlocked()) {
            this.pinSaved = pin;
        }
    }

    @Override
    public void unlock(int pin) {
        if(this.pinSaved == pin){
            this.doorState = LockStates.Unlocked;
        }
        else{
            this.failedAttempts++;
            if(this.failedAttempts == FAILED_ATTEMPTS_LIMIT){
                this.doorState = LockStates.Blocked;
            }
        }
    }

    @Override
    public void lock() throws Exception {
        this.doorState = LockStates.Locked;
        if(this.pinSaved == NO_PIN_VALUE){
            throw new Exception("Pin not set");
        }
    }

    @Override
    public boolean isLocked() {
        return (this.doorState == LockStates.Locked);
    }

    @Override
    public boolean isBlocked() {
        return (this.doorState == LockStates.Blocked);
    }

    @Override
    public int getMaxAttempts() {
        return FAILED_ATTEMPTS_LIMIT;
    }

    @Override
    public int getFailedAttempts() {
        return failedAttempts;
    }

    @Override
    public void reset() {
        this.pinSaved = NO_PIN_VALUE;
        this.failedAttempts = 0;
        this.doorState = LockStates.Open;
    }
}
