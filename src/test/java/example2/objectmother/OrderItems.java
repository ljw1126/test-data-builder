package example2.objectmother;

import example2.OrderItem;

public class OrderItems {
    private OrderItems() {}

    public static OrderItem createOrderItem(String coffeeMug) {
        return new OrderItem(coffeeMug, 10);
    }
}
