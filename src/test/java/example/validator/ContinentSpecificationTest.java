package example.validator;

import static example.builder.ContinentBuilder.*;
import static org.assertj.core.api.Assertions.*;

import example.*;
import example.builder.ContinentBuilder;
import example.builder.PlanetBuilder;
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

    @DisplayName("Test Data Builder 패턴을 이용해 리팩터링하면 테스트와 관련 없는 불필요한 정보를 제거할 수 있다")
    @Test
    void continentSizeByTestDataBuilderPattern() {
        Planet planet = PlanetBuilder.aPlanet().with(aContinent(), aContinent(), aContinent()).build();

        ContinentSpecification specification = new ContinentSpecification(3);

        assertThat(specification.isSatisfiedBy(planet)).isTrue();
    }
}
