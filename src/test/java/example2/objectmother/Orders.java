package example2.objectmother;

import example2.Customer;
import example2.Order;

public class Orders {
    private Orders() {}

    public static Order createOrderWithCustomer(Customer customer) {
        return new Order(1L, customer,0.0, null);
    }
}
