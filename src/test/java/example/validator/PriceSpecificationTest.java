package example.validator;

import static example.Money.*;
import static example.builder.AtomsphereBuilder.anAtomsphere;
import static example.builder.ContinentBuilder.aContinent;
import static example.builder.NationBuilder.*;
import static example.builder.OceanBuilder.*;
import static example.builder.PlanetBuilder.*;
import static org.assertj.core.api.Assertions.assertThat;

import example.*;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceSpecificationTest extends AbstractPlanetTest {
    @DisplayName("행성의 전체 제조 가격이 생쥐들이 제시한 계약 금액보다 작다")
    @Test
    void price() {
        Planet planet = createPlanet(wons(5000),
                Arrays.asList(wons(1000), wons(1000)),
                Arrays.asList(wons(1000), wons(1000)));

        PriceSpecification specification = new PriceSpecification(wons(9000));

        assertThat(specification.isSatisfiedBy(planet)).isTrue();
    }

    @DisplayName("Test Data Builder 패턴으로 리팩터링하여 제조 가격 이외의 불필요한 정보를 빌더 내부에 숨길 수 있다")
    @Test
    void priceByTestDataBuilderPattern() {
        Planet planet = aPlanet().with(anAtomsphere().with(wons(5000)))
                        .with(aContinent().with(aNation().with(wons(1000)), aNation().with(wons(1000))))
                        .with(anOcean().with(wons(1000)), anOcean().with(wons(1000)))
                        .build();

        PriceSpecification specification = new PriceSpecification(wons(9000));

        assertThat(specification.isSatisfiedBy(planet)).isTrue();
    }

}
