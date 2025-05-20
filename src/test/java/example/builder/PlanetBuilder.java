package example.builder;

import example.Atomsphere;
import example.Continent;
import example.Ocean;
import example.Planet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static example.builder.AtomsphereBuilder.*;
import static example.builder.ContinentBuilder.*;
import static example.builder.OceanBuilder.anOcean;

public class PlanetBuilder {
    private Atomsphere atomsphere = anAtomsphere().build();
    private List<Continent> contients = Arrays.asList(aContinent().build(), aContinent().build());
    private List<Ocean> oceans = Arrays.asList(anOcean().build(), anOcean().build());

    public static PlanetBuilder aPlanet() {
        return new PlanetBuilder();
    }

    @Deprecated
    public PlanetBuilder with(Atomsphere atomsphere) {
        this.atomsphere = atomsphere;
        return this;
    }

    public PlanetBuilder with(AtomsphereBuilder atomsphere) {
        this.atomsphere = atomsphere.build();
        return this;
    }

    @Deprecated
    public PlanetBuilder with(Continent... continents) {
        this.contients = Arrays.asList(continents);
        return this;
    }

    public PlanetBuilder with(ContinentBuilder... continents) {
        this.contients = new ArrayList<>();
        for(ContinentBuilder each : continents) {
            this.contients.add(each.build());
        }

        return this;
    }

    @Deprecated
    public PlanetBuilder with(Ocean... oceans) {
        this.oceans = Arrays.asList(oceans);
        return this;
    }

    public PlanetBuilder with(OceanBuilder... oceans) {
        this.oceans = new ArrayList<>();
        for(OceanBuilder each : oceans) {
            this.oceans.add(each.build());
        }

        return this;
    }

    public Planet build() {
        return new Planet(atomsphere, contients, oceans);
    }
}
