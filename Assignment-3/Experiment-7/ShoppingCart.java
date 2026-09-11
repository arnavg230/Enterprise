import java.util.ArrayList;
import java.util.Scanner;

class ApplicationException extends Exception {

    public ApplicationException(String message) {
        super(message);
    }
}

class ProductException extends ApplicationException {

    public ProductException(String message) {
        super(message);
    }
}

class ProductNotFoundException extends ProductException {

    public ProductNotFoundException(String message) {
        super(message);
    }
}

class OutOfStockException extends ProductException {

    public OutOfStockException(String message) {
        super(message);
    }
}

class PaymentException extends ApplicationException {

    public PaymentException(String message) {
        super(message);
    }
}

class InvalidPaymentException extends PaymentException {

    public InvalidPaymentException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends PaymentException {

    public InsufficientFundsException(String message) {
        super(message);
    }
}

class OrderException extends ApplicationException {

    public OrderException(String message) {
        super(message);
    }
}

class EmptyCartException extends OrderException {

    public EmptyCartException(String message) {
        super(message);
    }
}

public class ShoppingCart {

    static ArrayList<String> cart = new ArrayList<>();

    static void addProduct(String product)
            throws ProductNotFoundException,
            OutOfStockException {

        if (product.equalsIgnoreCase("laptop")) {

            cart.add("Laptop");
            System.out.println("Laptop added to cart.");

        } else if (product.equalsIgnoreCase("phone")) {

            cart.add("Phone");
            System.out.println("Phone added to cart.");

        } else if (product.equalsIgnoreCase("headphones")) {

            cart.add("Headphones");
            System.out.println("Headphones added to cart.");

        } else if (product.equalsIgnoreCase("camera")) {

            throw new OutOfStockException(
                    "Camera is currently out of stock."
            );

        } else {

            throw new ProductNotFoundException(
                    "Product not found."
            );
        }
    }

    static void removeProduct(String product)
            throws ProductNotFoundException {

        if (cart.remove(product)) {
            System.out.println("Product removed from cart.");
        } else {
            throw new ProductNotFoundException(
                    "Product is not present in cart."
            );
        }
    }

    static void searchProduct(String product)
            throws ProductNotFoundException {

        if (product.equalsIgnoreCase("laptop")
                || product.equalsIgnoreCase("phone")
                || product.equalsIgnoreCase("headphones")) {

            System.out.println("Product is available.");

        } else {
            throw new ProductNotFoundException(
                    "Product not found."
            );
        }
    }

    static void makePayment(String paymentMode)
            throws InvalidPaymentException,
            InsufficientFundsException {

        if (!paymentMode.equalsIgnoreCase("card")
                && !paymentMode.equalsIgnoreCase("upi")) {

            throw new InvalidPaymentException(
                    "Invalid payment method."
            );
        }

        double availableFunds = 500;

        if (availableFunds < 1000) {
            throw new InsufficientFundsException(
                    "Insufficient funds for payment."
            );
        }

        System.out.println("Payment successful using "
                + paymentMode + ".");
    }

    static void placeOrder()
            throws EmptyCartException {

        if (cart.isEmpty()) {
            throw new EmptyCartException(
                    "Cannot place order. Cart is empty."
            );
        }

        System.out.println("Order placed successfully.");
        cart.clear();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            while (true) {

                System.out.println("\nShopping Cart");
                System.out.println("1. Add product");
                System.out.println("2. Remove product");
                System.out.println("3. Search product");
                System.out.println("4. View cart");
                System.out.println("5. Make payment");
                System.out.println("6. Place order");
                System.out.println("7. Exit");

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                try {

                    if (choice == 1) {

                        System.out.print("Enter product name: ");
                        String product = sc.nextLine();

                        addProduct(product);

                    } else if (choice == 2) {

                        System.out.print("Enter product name: ");
                        String product = sc.nextLine();

                        removeProduct(product);

                    } else if (choice == 3) {

                        System.out.print("Enter product name: ");
                        String product = sc.nextLine();

                        searchProduct(product);

                    } else if (choice == 4) {

                        if (cart.isEmpty()) {
                            System.out.println("Cart is empty.");
                        } else {
                            System.out.println("Cart: " + cart);
                        }

                    } else if (choice == 5) {

                        System.out.print(
                                "Enter payment method (card/upi): "
                        );
                        String payment = sc.nextLine();

                        makePayment(payment);

                    } else if (choice == 6) {

                        placeOrder();

                    } else if (choice == 7) {

                        System.out.println("Exiting...");
                        break;

                    } else {

                        System.out.println("Invalid choice.");
                    }

                } catch (ApplicationException e) {

                    System.out.println("Error: " + e.getMessage());
                }
            }

        } finally {
            sc.close();
        }
    }
}