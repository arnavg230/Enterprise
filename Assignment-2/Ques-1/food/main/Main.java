package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.service.OrderUtility;

public class Main {

    public static void main(String[] args) {

        FoodOrder.setRestaurantName("FoodExpress");

        FoodOrder[] orders = new FoodOrder[6];

        orders[0] = new RegularOrder(101, "Arnav", 500);
        orders[1] = new PremiumOrder(102, "Rahul", 1000);
        orders[2] = new RegularOrder(103, "Aman", 750);
        orders[3] = new PremiumOrder(104, "Riya", 1200);
        orders[4] = new RegularOrder(105, "Karan", 650);
        orders[5] = new PremiumOrder(106, "Simran", 900);

        System.out.println("==================================");
        System.out.println("        " + FoodOrder.getRestaurantName());
        System.out.println("           FOOD ORDER BILL");
        System.out.println("==================================");

        for (int i = 0; i < orders.length; i++) {

            if (OrderUtility.validateOrder(orders[i])) {
                OrderUtility.generateOrderSummary(orders[i]);
            } else {
                System.out.println("Invalid order details for Order ID: "
                        + orders[i].getOrderId());
            }
        }

        FoodOrder.displayTotalOrders();
    }
}