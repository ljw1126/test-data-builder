package example.validator;

import example.Planet;

public class AndSpecification extends AbstractSpecification {
    private Specification one;
    private Specification other;

    public AndSpecification(Specification one, Specification other) {
        this.one = one;
        this.other = other;
    }

    @Override
    public boolean isSatisfiedBy(Planet planet) {
        return one.isSatisfiedBy(planet) && one.isSatisfiedBy(planet);
    }
}
