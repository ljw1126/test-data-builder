package example.validator;

import example.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractPlanetTest {
    protected Planet createPlanet(Continent... continents) {
        Atomsphere atomsphere = new Atomsphere(Money.wons(5000),
                new Element("N", Ratio.from(0.8)),
                new Element("O", Ratio.from(0.2)));

        List<Ocean> oceans = Arrays.asList(new Ocean("태평양", Money.wons(1000)),
                new Ocean("대서양", Money.wons(1000)));

        return new Planet(atomsphere, Arrays.asList(continents), oceans);
    }

    protected Planet createPlanet(Money atomspherePrice,
                                List<Money> nationsPrice,
                                List<Money> oceansPrice) {
        return new Planet(createAtomsphere(atomspherePrice),
                createContinents(nationsPrice),
                getOceans(oceansPrice));
    }

    private List<Continent> createContinents(List<Money> nationsPrice) {
        List<Continent> result = new ArrayList<>();
        for(Money each : nationsPrice) {
            result.add(new Continent("대륙", new Nation("국가", each)));
        }

        return result;
    }

    private Atomsphere createAtomsphere(Money atomspherePrice) {
        return new Atomsphere(atomspherePrice,
                new Element("N", Ratio.from(0.8)),
                new Element("O", Ratio.from(0.2)));
    }

    private List<Ocean> getOceans(List<Money> oceansPrice) {
        List<Ocean> result = new ArrayList<>();
        for(Money each : oceansPrice) {
            result.add(new Ocean("대양", each));
        }

        return result;
    }
}
