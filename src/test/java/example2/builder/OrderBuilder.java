package example2.builder;

import example2.Customer;
import example2.Order;
import example2.OrderItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static example2.builder.CustomerBuilder.*;

// Test Data Builder Pattern, 기본값 설정 가능
public class OrderBuilder {
    private Long orderId = 1L;
  private Customer customer = aCustomer().build();
    private List<OrderItem> orderItems = new ArrayList<>();
    private Double discountRate = 0.0;
    private String couponCode;

    private OrderBuilder() {}

    private OrderBuilder(OrderBuilder copy) {
        this.orderId = copy.orderId;
        this.customer = copy.customer;
        this.orderItems = copy.orderItems;
        this.discountRate = copy.discountRate;
        this.couponCode = copy.couponCode;
    }

    public static OrderBuilder aOrder() {
        return new OrderBuilder();
    }

    public OrderBuilder but() {
        return new OrderBuilder(this);
    }

    public OrderBuilder with(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    @Deprecated
    public OrderBuilder with(Customer customer) {
        this.customer = customer;
        return this;
    }

    public OrderBuilder with(CustomerBuilder customer) {
        this.customer = customer.build();
        return this;
    }

    @Deprecated
    public OrderBuilder with(OrderItem... orderItems) {
        this.orderItems.addAll(Arrays.asList(orderItems));
        return this;
    }

    public OrderBuilder with(OrderItemBuilder... orderItems) {
        for(OrderItemBuilder each : orderItems) {
            this.orderItems.add(each.build());
        }
        return this;
    }

    public OrderBuilder with(Double discountRate) {
        this.discountRate = discountRate;
        return this;
    }

    public OrderBuilder with(String couponCode) {
        this.couponCode = couponCode;
        return this;
    }

    public Order build() {
        Order aOrder = new Order(orderId, customer, discountRate, couponCode);
        orderItems.forEach(aOrder::addOrderItem);
        return aOrder;
    }
}
