package example2.objectmother;

import example2.Customer;
import example2.Order;
import example2.builder.CustomerBuilder;
import example2.builder.OrderBuilder;

public class Orders {
    private Orders() {}

    public static Order createOrderWithCustomer(Customer customer) {
        return new Order(1L, customer,0.0, null);
    }

    // Combine Builder Pattern and Object Mother Pattern
    public static OrderBuilder anOrder() {
        return OrderBuilder.aOrder()
                .with(1L)
                .with(CustomerBuilder.aCustomer().build())
                .with(0.0);
    }
}
