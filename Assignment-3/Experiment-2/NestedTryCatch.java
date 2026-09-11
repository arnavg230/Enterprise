public class NestedTryCatch {

    public static void main(String[] args) {

        try {
            System.out.println("Outer try block");

            try {
                int a = 10;
                int b = 0;
                System.out.println(a / b);
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: Cannot divide by zero");
            }

            int arr[] = {1, 2, 3};
            System.out.println(arr[5]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch: Invalid array index");
        }

        System.out.println("Program continues...");
    }
}