package example2.builder;

import example2.OrderItem;

public class OrderItemBuilder {
    private String name;
    private int quantity;

    public static OrderItemBuilder aOrderItem() {
        return new OrderItemBuilder();
    }

    public OrderItemBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public OrderItemBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderItem build() {
        return new OrderItem(name, quantity);
    }
}
