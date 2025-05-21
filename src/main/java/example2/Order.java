package example2;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long orderId;
    private Customer customer;
    private List<OrderItem> orderItems = new ArrayList<>();
    private Double discountRate;
    private String couponCode;

    public Order(Long orderId, Customer customer, Double discountRate, String couponCode) {
        this.orderId = orderId;
        this.customer = customer;
        this.discountRate = discountRate;
        this.couponCode = couponCode;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }
}
