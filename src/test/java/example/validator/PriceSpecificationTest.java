package example.validator;

import static org.assertj.core.api.Assertions.assertThat;

import example.*;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceSpecificationTest extends AbstractPlanetTest {
    @DisplayName("행성의 실제 제조 가격이 생쥐들이 제시한 계약 금액보다 작다")
    @Test
    void price() {
        Planet planet = createPlanet(Money.wons(5000),
                Arrays.asList(Money.wons(1000), Money.wons(1000)),
                Arrays.asList(Money.wons(1000), Money.wons(1000)));

        PriceSpecification specification = new PriceSpecification(Money.wons(9000));

        assertThat(specification.isSatisfiedBy(planet)).isTrue();
    }
}
