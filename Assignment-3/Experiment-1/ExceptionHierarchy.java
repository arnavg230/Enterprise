public class ExceptionHierarchy {

    public static void main(String[] args) {

        // ArithmeticException
        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: Cannot divide by zero");
        }

        // NullPointerException
        try {
            String str = args.length == 0 ? null : "Hello";
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: String is null");
        }

        // ArrayIndexOutOfBoundsException
        try {
            int arr[] = {10, 20, 30};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: Invalid array index");
        }

        // NumberFormatException
        try {
            int num = Integer.parseInt("abc");
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Invalid number format");
        }
    }
}