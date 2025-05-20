package example.validator;

import example.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ContinentSpecificationTest {

    @DisplayName("행성에 포함된 대륙의 개수가 정해진 명세에 일치한다")
    @Test
    void continentSize() {
        Planet planet = createPlanet(new Continent("아시아"), new Continent("유럽"));

        ContinentSpecification specification = new ContinentSpecification(2);

        assertThat(specification.isSatisfiedBy(planet)).isTrue();
    }

    // 매개변수화된 생성 메서드(PARAMETERIZED CREATION METHOD)
    private Planet createPlanet(Continent... continents) {
        Atomsphere atomsphere = new Atomsphere(Money.wons(5000),
                new Element("N", Ratio.from(0.8)),
                new Element("O", Ratio.from(0.2)));

        List<Ocean> oceans = Arrays.asList(new Ocean("태평양", Money.wons(1000)),
                new Ocean("대서양", Money.wons(1000)));

        return new Planet(atomsphere, Arrays.asList(continents), oceans);
    }
}
