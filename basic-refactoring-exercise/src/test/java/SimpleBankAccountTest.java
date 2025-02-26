import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {
    private static final int DEPOSIT_AMOUNT = 100;
    private static final int SMALLER_WITHDRAW_AMOUNT = 70;
    private static final int GREATER_WITHDRAW_AMOUNT = 150;
    private static final int WITHDRAWAL_FEE = 1;
    private static final int FIRST_BALANCE = 0;
    private static final int FIRST_ACCOUNT_HOLDER_ID = 1;
    private static final int SECOND_ACCOUNT_HOLDER_ID = 2;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", FIRST_ACCOUNT_HOLDER_ID);
        bankAccount = new SimpleBankAccount(accountHolder, FIRST_BALANCE);
    }

    @Test
    void testInitialBalance() {
        assertEquals(FIRST_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.deposit(SECOND_ACCOUNT_HOLDER_ID, DEPOSIT_AMOUNT/2);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), SMALLER_WITHDRAW_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT- SMALLER_WITHDRAW_AMOUNT -WITHDRAWAL_FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(SECOND_ACCOUNT_HOLDER_ID, SMALLER_WITHDRAW_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdrawGreaterThanBalance(){
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), GREATER_WITHDRAW_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

}
