package DefiningClasses.Lab.BankAccounts;

public class BankAccount {
    private static int accountsCounter = 0;
    private static double interestRate;
    private final int accountID;
    private double balance;

    public BankAccount() {
        accountsCounter++;
        this.accountID = accountsCounter;
        this.balance = 0;
    }

    public static void adjustInterestRate(double rate) {
        interestRate = rate;
    }

    public void printAccumulatedInterestPer(int years) {
        double accumulatedInterest = (interestRate * this.balance) * years;
        System.out.printf("%.2f%n",accumulatedInterest);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public int getAccountID() {
        return accountID;
    }

    public static void reportAccountIsCreated(int accountID) {
        System.out.printf("Account ID%d created%n", accountID);
    }

    public static void reportAmountIsDeposited(int accountID, double amount) {
        System.out.printf("Deposited %.0f to ID%d%n", amount, accountID);
    }
}
