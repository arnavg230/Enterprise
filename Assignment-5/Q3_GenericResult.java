import java.util.Objects;
import java.util.Optional;

public class Q3_GenericResult<T extends Number> {
    private T marks;
    private double maximumMarks;

    public Q3_GenericResult(T marks, double maximumMarks) {
        this.marks = Objects.requireNonNull(marks, "Marks cannot be null");
        if (maximumMarks <= 0) {
            throw new IllegalArgumentException("Maximum marks must be positive");
        }
        this.maximumMarks = maximumMarks;
    }

    public double getPercentage() {
        return (marks.doubleValue() / maximumMarks) * 100;
    }

    public boolean hasPassed(double passPercentage) {
        return getPercentage() >= passPercentage;
    }

    public Optional<String> getResult(double passPercentage) {
        if (marks == null) {
            return Optional.empty();
        }

        String status = hasPassed(passPercentage) ? "Pass" : "Fail";
        return Optional.of(status + " (" + String.format("%.2f", getPercentage()) + "%)");
    }

    public static void main(String[] args) {
        Q3_GenericResult<Integer> result1 = new Q3_GenericResult<>(78, 100);
        Q3_GenericResult<Double> result2 = new Q3_GenericResult<>(32.5, 50);

        System.out.println("Percentage: " + result1.getPercentage() + "%");
        System.out.println("Passed: " + result1.hasPassed(40));
        System.out.println("Result: " + result1.getResult(40).orElse("Result not available"));

        System.out.println("\nPercentage: " + result2.getPercentage() + "%");
        System.out.println("Result: " + result2.getResult(40).orElse("Result not available"));
    }
}
