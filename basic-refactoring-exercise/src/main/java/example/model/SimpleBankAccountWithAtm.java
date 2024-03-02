package example.model;

public class SimpleBankAccountWithAtm implements BankAccount {
    private static final double ATM_FEE = 1.;

    private final BankAccount bankAccount;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        bankAccount = new SimpleBankAccount(holder, balance);
    }

    @Override
    public AccountHolder getHolder() {
        return bankAccount.getHolder();
    }

    @Override
    public double getBalance() {
        return bankAccount.getBalance();
    }

    private boolean isDepositAllowed(final double amount) {
        return bankAccount.getBalance() + amount > ATM_FEE;
    }

    @Override
    public void deposit(int userID, double amount) {
        if (isDepositAllowed(amount)) {
            bankAccount.deposit(userID, amount - ATM_FEE);
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        bankAccount.withdraw(userID, amount + ATM_FEE);
    }
}
