package example.builder;

import example.Money;
import example.Ocean;

public class OceanBuilder {
    private String name = "바다";
    private Money price = Money.wons(1000);

    public static OceanBuilder anOcean() {
        return new OceanBuilder();
    }

    public OceanBuilder with(String name) {
        this.name = name;
        return this;
    }

    public OceanBuilder with(Money price) {
        this.price = price;
        return this;
    }

    public Ocean build() {
        return new Ocean(name, price);
    }
}
