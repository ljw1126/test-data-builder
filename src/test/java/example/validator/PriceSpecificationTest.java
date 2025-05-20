package example.validator;

import example.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PriceSpecificationTest {
    @DisplayName("행성의 실제 제조 가격이 생쥐들이 제시한 계약 금액보다 작다")
    @Test
    void price() {
        Planet planet = createPlanet();

        PriceSpecification specification = new PriceSpecification(Money.wons(9000));

        assertThat(specification.isSatisfiedBy(planet)).isTrue();
    }

    // 생성 메서드 (CREATION METHOD)
    private Planet createPlanet() {
        Atomsphere atomsphere = new Atomsphere(Money.wons(5000),
                new Element("N", Ratio.from(0.8)),
                new Element("O", Ratio.from(0.2)));

        List<Continent> continents = Arrays.asList(new Continent("아시아", new Nation("대한민국", Money.wons(1000))),
                new Continent("유럽", new Nation("영국", Money.wons(1000))));

        List<Ocean> oceans = Arrays.asList(new Ocean("태평양", Money.wons(1000)),
                new Ocean("대서양", Money.wons(1000)));

        Planet planet = new Planet(atomsphere, continents, oceans);
        return planet;
    }
}
