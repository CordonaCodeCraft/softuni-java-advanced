
// Judge ready

package DefiningClasses.Lab.BankAccounts;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    final static Map<Integer, BankAccount> bankAccounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            String command = s.nextLine();
            if ("End".equals(command)) {
                break;
            } else {
                String[] tokens = command.split("\\s+");
                String actionType = tokens[0];
                switch (actionType) {
                    case "Create":
                        createNewBankAccount();
                        break;
                    case "Deposit": {
                        depositAmount(tokens);
                        break;
                    }
                    case "SetInterest":
                        setInterest(tokens);
                        break;
                    case "GetInterest": {
                        getAccumulatedInterest(tokens);
                        break;
                    }
                }
            }
        }
    }

    private static void createNewBankAccount() {
        BankAccount newBankAccount = new BankAccount();
        int accountID = newBankAccount.getAccountID();
        bankAccounts.putIfAbsent(accountID, newBankAccount);
        BankAccount.reportAccountIsCreated(accountID);
    }

    private static void depositAmount(String[] tokens) {
        int targetID = Integer.parseInt(tokens[1]);
        double amount = Double.parseDouble(tokens[2]);

        if (bankAccounts.containsKey(targetID)) {
            bankAccounts.get(targetID).deposit(amount);
            BankAccount.reportAmountIsDeposited(targetID, amount);
        } else {
            System.out.println("Account does not exist");
        }                                                                                                      
    }

    private static void setInterest(String[] tokens) {
        double interest = Double.parseDouble(tokens[1]);
        BankAccount.adjustInterestRate(interest);
    }

    private static void getAccumulatedInterest(String[] tokens) {
        int targetID = Integer.parseInt(tokens[1]);
        int year = Integer.parseInt(tokens[2]);
        if (bankAccounts.containsKey(targetID)) {
            bankAccounts.get(targetID).printAccumulatedInterestPer(year);
        } else {
            System.out.println("Account does not exist");
        }
    }
}
