package example2.builder;

import example2.Address;
import example2.Customer;

public class CustomerBuilder {
    private Long id;
    private String name;
    private Address address;

    private CustomerBuilder() {}

    public static CustomerBuilder aCustomer() {
        return new CustomerBuilder();
    }

    public CustomerBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CustomerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Deprecated
    public CustomerBuilder withAddress(Address address) {
        this.address = address;
        return this;
    }

    public CustomerBuilder withAddress(AddressBuilder address) {
        this.address = address.build();
        return this;
    }

    public Customer build() {
        return new Customer(id, name, address);
    }
}
