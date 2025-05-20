package example.validator;


import example.Planet;

// Conttinent 대륙
public class ContinentSpecification extends AbstractSpecification {
    private int continentSize;

    public ContinentSpecification(int continentSize) {
        this.continentSize = continentSize;
    }

    @Override
    public boolean isSatisfiedBy(Planet planet) {
        return planet.getContinents().size() == continentSize;
    }
}
