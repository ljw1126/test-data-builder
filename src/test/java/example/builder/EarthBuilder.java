package example.builder;

import example.Planet;

public class EarthBuilder extends AbstractPlanetBuilder {
    public Planet build() {
        return planet(atomsphere(price(5000), element("N", 0.8), element("O", 0.2)),
                    continents(continent(name("아시아"), nation(name("대한민국"), price(1000)), nation("미국", price(1000))),
                            continent(name("유럽"), nation(name("영국"), price(1000)), nation("프랑스", price(1000)))),
                    oceans(ocean(name("태평양"), price(1000)), ocean("대서양", price(1000))));
    }
}
