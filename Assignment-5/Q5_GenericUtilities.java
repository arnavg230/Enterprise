import java.util.Objects;
import java.util.Optional;

public class Q5_GenericUtilities {
    public static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }

    public static <T> T getDefault(Optional<T> value, T defaultValue) {
        return value.orElse(defaultValue);
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        Objects.requireNonNull(a, "First value cannot be null");
        Objects.requireNonNull(b, "Second value cannot be null");

        return a.compareTo(b) >= 0 ? a : b;
    }

    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }

    public static void main(String[] args) {
        System.out.println("Are strings equal? " + isEqual("Java", "Java"));
        System.out.println("Are integers equal? " + isEqual(10, 20));

        Optional<String> name = Optional.of("Arnav");
        Optional<String> emptyName = Optional.empty();

        System.out.println("Name: " + getDefault(name, "Unknown"));
        System.out.println("Default name: " + getDefault(emptyName, "Unknown"));

        System.out.println("Larger integer: " + max(12, 25));
        System.out.println("Larger string: " + max("Apple", "Mango"));

        String value = null;
        System.out.println("Is value null? " + isNull(value));
        System.out.println("Is name null? " + isNull("Arnav"));
    }
}
