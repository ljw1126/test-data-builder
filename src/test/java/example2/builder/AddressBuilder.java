package example2.builder;

import example2.Address;

public class AddressBuilder {
    private String street = "Some street";
    private String city = "Some city";
    private String postalCode = "Some postal code";
    private String country = "Some country";

    public static AddressBuilder address() {
        return new AddressBuilder();
    }

    public AddressBuilder withStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public AddressBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public Address build() {
        return new Address(street, city, postalCode, country);
    }
}
