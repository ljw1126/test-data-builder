package example.validator;

import static org.assertj.core.api.Assertions.*;

import example.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContinentSpecificationTest extends AbstractPlanetTest {

    @DisplayName("행성에 포함된 대륙의 개수가 정해진 명세에 일치한다")
    @Test
    void continentSize() {
        Planet planet = createPlanet(new Continent("아시아"), new Continent("유럽"));

        ContinentSpecification specification = new ContinentSpecification(2);

        assertThat(specification.isSatisfiedBy(planet)).isTrue();
    }
}
