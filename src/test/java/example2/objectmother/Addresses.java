package example2.objectmother;

import example2.Address;

public class Addresses {
    private Addresses() {}

    public static Address createAddressWithCountry(String country) {
        return new Address("some street", "some city", "some postal code", country);
    }
}
