package example2;

public class Customer {
    private Long id;
    private String name;
    private Address address;

    public Customer(Long id, String name) {
        this(id, name, null);
    }

    public Customer(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
