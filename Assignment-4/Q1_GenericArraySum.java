public class Q1_GenericArraySum {
    // This method works with any type that extends Number
    public static <T extends Number> double sum(T[] arr) {
        double total = 0;

        for (T value : arr) {
            total += value.doubleValue();
        }

        return total;
    }

    public static void main(String[] args) {
        Integer[] integers = {10, 20, 30, 40};
        Float[] floats = {1.5f, 2.5f, 3.0f};
        Double[] doubles = {2.25, 4.5, 1.25};

        System.out.println("Sum of integers: " + sum(integers));
        System.out.println("Sum of floats: " + sum(floats));
        System.out.println("Sum of doubles: " + sum(doubles));
    }
}
