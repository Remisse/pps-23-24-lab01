import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleBankAccountWithAtmTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testCannotCoverDepositFee() {
        bankAccount.deposit(accountHolder.getId(), .5);
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testUselessDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(accountHolder.getId(), .5);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(28, bankAccount.getBalance());
    }

    @Test
    void testCannotCoverWithdrawalFee() {
        bankAccount.deposit(accountHolder.getId(), 101);
        bankAccount.withdraw(accountHolder.getId(), 100);
        assertEquals(100, bankAccount.getBalance());
    }
}
