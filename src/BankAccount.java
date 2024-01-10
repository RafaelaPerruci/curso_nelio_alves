public class BankAccount {

    private int accountNumber;
    private String holder;
    private double balance;

    public BankAccount(int accountNumber, String holder, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        deposit(initialDeposit);
    }
    public BankAccount(int accountNumber, String holder){
        this.accountNumber = accountNumber;
        this.holder = holder;

    }
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolder() {
        return holder;
    }
    public void setHolder(String holder){
        this.holder = holder;
    }
    public double getBalance() {
        return balance;
    }

    public void deposit(double value){
        this.balance += value;
    }
    public void withDraw(double value){
        this.balance -= value;
    }

    @Override
    public String toString() {
        return "Account number: " + accountNumber +
                "\nHolder: " + holder +
                "\nBalance: $" + balance;
    }
}
