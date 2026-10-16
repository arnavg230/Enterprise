import java.util.Optional;

public class Q2_OptionalEmail {
    public static void main(String[] args) {
        Optional<String> email = Optional.of("student@example.com");
        Optional<String> emptyEmail = Optional.empty();

        // Display email only when it is present
        email.ifPresent(value -> System.out.println("Email: " + value));

        // Give a default value if the email is missing
        String emailToUse = emptyEmail.orElse("default@example.com");
        System.out.println("Email using orElse: " + emailToUse);

        // Handle a missing email using orElseThrow
        try {
            String requiredEmail = emptyEmail.orElseThrow(
                    () -> new IllegalStateException("Email address is missing"));
            System.out.println(requiredEmail);
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
