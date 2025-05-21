package example2.objectmother;

import example2.Address;
import example2.Customer;

public class Customers {
    private Customers() {}

    public static Customer createCustomerWithAddress(Address address) {
        return new Customer(1L, "tester", address);
    }
}
