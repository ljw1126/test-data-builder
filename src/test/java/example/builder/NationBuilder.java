package example.builder;

import example.Money;
import example.Nation;

public class NationBuilder {
    private String name = "대한민국";
    private Money price = Money.wons(1000);

    public static NationBuilder aNation() {
        return new NationBuilder();
    }

    public NationBuilder with(String name) {
        this.name = name;
        return this;
    }

    public NationBuilder with(Money price) {
        this.price = price;
        return this;
    }

    public Nation build() {
        return new Nation(name, price);
    }
}
