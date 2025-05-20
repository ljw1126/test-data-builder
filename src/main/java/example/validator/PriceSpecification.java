package example.validator;

import example.Money;
import example.Planet;

public class PriceSpecification extends AbstractSpecification{
    private Money price;

    public PriceSpecification(Money price) {
        this.price = price;
    }

    @Override
    public boolean isSatisfiedBy(Planet planet) {
        return price.isGraterThanOrEqual(planet.getPrice());
    }
}
