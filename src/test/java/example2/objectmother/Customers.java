package example2.objectmother;

import example2.Address;
import example2.Customer;
import example2.builder.AddressBuilder;
import example2.builder.CustomerBuilder;

public class Customers {
    private Customers() {}

    public static Customer createCustomerWithAddress(Address address) {
        return new Customer(1L, "tester", address);
    }

    // Combine Builders and Object Mothers
    public static CustomerBuilder aCustomer() {
        return CustomerBuilder.aCustomer()
                .withId(1L)
                .withName("tester")
                .withAddress(AddressBuilder.address().build());
    }
}
