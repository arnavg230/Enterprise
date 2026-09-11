import java.util.Scanner;

class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {

    public InvalidAmountException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends Exception {

    public AccountNotFoundException(String message) {
        super(message);
    }
}

public class BankAccount {

    static double balance = 10000;

    static void deposit(double amount)
            throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Deposit amount must be greater than zero."
            );
        }

        balance = balance + amount;
        System.out.println("Amount deposited successfully.");
    }

    static void withdraw(double amount)
            throws InvalidAmountException,
            InsufficientBalanceException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Withdrawal amount must be greater than zero."
            );
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance."
            );
        }

        balance = balance - amount;
        System.out.println("Amount withdrawn successfully.");
    }

    static void checkAccount(String accountNumber)
            throws AccountNotFoundException {

        if (!accountNumber.equals("1024170057")) {
            throw new AccountNotFoundException(
                    "Account not found."
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter account number: ");
            String accountNumber = sc.nextLine();

            checkAccount(accountNumber);

            System.out.println("Account found.");
            System.out.println("Current balance: " + balance);

            System.out.print("Enter deposit amount: ");
            double depositAmount = sc.nextDouble();

            deposit(depositAmount);

            System.out.println("Balance after deposit: " + balance);

            System.out.print("Enter withdrawal amount: ");
            double withdrawAmount = sc.nextDouble();

            withdraw(withdrawAmount);

            System.out.println("Balance after withdrawal: " + balance);

        } catch (AccountNotFoundException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            sc.close();
        }
    }
}