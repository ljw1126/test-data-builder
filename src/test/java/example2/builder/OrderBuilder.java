package example2.builder;

import example2.Customer;
import example2.Order;
import example2.OrderItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Test Data Builder Pattern, 기본값 설정 가능
public class OrderBuilder {
    private Long orderId;
    private Customer customer;
    private List<OrderItem> orderItems = new ArrayList<>();
    private Double discountRate;
    private String couponCode;

    public static OrderBuilder aOrder() {
        return new OrderBuilder();
    }

    public OrderBuilder withId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public OrderBuilder withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public OrderBuilder withOrderItems(OrderItem... orderItems) {
        this.orderItems.addAll(Arrays.asList(orderItems));
        return this;
    }

    public OrderBuilder withDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
        return this;
    }

    public OrderBuilder withCouponCode(String couponCode) {
        this.couponCode = couponCode;
        return this;
    }

    public Order build() {
        Order aOrder = new Order(orderId, customer, discountRate, couponCode);
        orderItems.forEach(aOrder::addOrderItem);
        return aOrder;
    }
}
