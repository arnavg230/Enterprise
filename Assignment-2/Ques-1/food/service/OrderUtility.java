package food.service;

import food.model.FoodOrder;
import food.model.Discountable;
import food.utility.ValidationUtility;

public class OrderUtility {

    public static boolean validateOrder(FoodOrder order) {

        if (!ValidationUtility.validateAmount(order.getAmount())) {
            return false;
        }

        if (!ValidationUtility.validateCustomerName(order.getCustomerName())) {
            return false;
        }

        return true;
    }

    public static void generateOrderSummary(FoodOrder order) {

        System.out.println("----------------------------------");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer Name: " + order.getCustomerName());
        System.out.println("Order Type: " + order.getClass().getSimpleName());

        System.out.println("Bill Amount: Rs. " + order.getAmount());

        double discount = 0;

        if (order instanceof Discountable) {
            Discountable d = (Discountable) order;
            discount = d.applyDiscount();
        }

        double deliveryCharge = order.calculateDeliveryCharge();

        double finalAmount = order.getAmount() - discount + deliveryCharge;

        System.out.println("Discount: Rs. " + discount);
        System.out.println("Delivery Charge: Rs. " + deliveryCharge);
        System.out.println("Final Payable Amount: Rs. " + finalAmount);

        System.out.println("----------------------------------");
    }
}