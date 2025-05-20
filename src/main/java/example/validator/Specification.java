package example.validator;


import example.Planet;

public interface Specification {
    boolean isSatisfiedBy(Planet planet);
    Specification and(Specification other);
}
