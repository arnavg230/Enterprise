import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter first number: ");
            double num1 = Double.parseDouble(sc.nextLine());

            System.out.print("Enter second number: ");
            double num2 = Double.parseDouble(sc.nextLine());

            System.out.print("Enter operator (+, -, *, /): ");
            char operator = sc.nextLine().charAt(0);

            double result;

            switch (operator) {

                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    result = num1 / num2;
                    break;

                default:
                    throw new IllegalArgumentException("Invalid operator");
            }

            System.out.println("Result = " + result);

        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input.");

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid operator.");
        }
    }
}