import java.util.Scanner;

class InvalidUsernameException extends Exception {

    public InvalidUsernameException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends Exception {

    public InvalidPasswordException(String message) {
        super(message);
    }
}

class AccountLockedException extends Exception {

    public AccountLockedException(String message) {
        super(message);
    }
}

public class LoginSystem {

    static String correctUsername = "student";
    static String correctPassword = "12345";

    static void login(String username, String password)
            throws InvalidUsernameException,
            InvalidPasswordException {

        if (!username.equals(correctUsername)) {
            throw new InvalidUsernameException(
                    "Username is incorrect."
            );
        }

        if (!password.equals(correctPassword)) {
            throw new InvalidPasswordException(
                    "Password is incorrect."
            );
        }

        System.out.println("Login successful.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int attempts = 0;
        int maxAttempts = 3;
        boolean loggedIn = false;

        while (attempts < maxAttempts && !loggedIn) {

            try {
                System.out.print("Enter username: ");
                String username = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                login(username, password);

                loggedIn = true;

            } catch (InvalidUsernameException e) {

                attempts++;
                System.out.println(e.getMessage());
                System.out.println("Attempts left: "
                        + (maxAttempts - attempts));

            } catch (InvalidPasswordException e) {

                attempts++;
                System.out.println(e.getMessage());
                System.out.println("Attempts left: "
                        + (maxAttempts - attempts));
            }

            if (attempts == maxAttempts && !loggedIn) {

                try {
                    throw new AccountLockedException(
                            "Account locked due to too many failed attempts."
                    );

                } catch (AccountLockedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        sc.close();
    }
}