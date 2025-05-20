package example.builder;

import example.*;

import java.util.Arrays;
import java.util.List;

// 객체 범위(Object Scoping) 기법을 위해 추가
public abstract class AbstractPlanetBuilder {
    protected Money price(long price) {
        return Money.wons(price);
    }

    protected Element element(String name, double ratio) {
        return Element.element(name, Ratio.from(ratio));
    }

    protected Atomsphere atomsphere(Money price, Element... elements) {
        return new Atomsphere(price, elements);
    }

    protected String name(String name) { // 바로 리턴
        return name;
    }

    protected Nation nation(String name, Money price) {
        return new Nation(name, price);
    }

    protected List<Ocean> oceans(Ocean... oceans) {
        return Arrays.asList(oceans);
    }

    protected Ocean ocean(String name, Money price) {
        return new Ocean(name, price);
    }

    protected List<Continent> continents(Continent... continents) {
        return Arrays.asList(continents);
    }

    protected Continent continent(String name, Nation... nations) {
        return new Continent(name, nations);
    }

    protected Planet planet(Atomsphere atomsphere, List<Continent> continents, List<Ocean> oceans) {
        return new Planet(atomsphere, continents, oceans);
    }
}
