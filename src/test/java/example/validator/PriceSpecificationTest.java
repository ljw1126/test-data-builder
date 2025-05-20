package example.validator;

import example.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PriceSpecificationTest {
    @DisplayName("행성의 실제 제조 가격이 생쥐들이 제시한 계약 금액보다 작다")
    @Test
    void price() {
        Planet planet = createPlanet(Money.wons(5000),
                Arrays.asList(Money.wons(1000), Money.wons(1000)),
                Arrays.asList(Money.wons(1000), Money.wons(1000)));

        PriceSpecification specification = new PriceSpecification(Money.wons(9000));

        assertThat(specification.isSatisfiedBy(planet)).isTrue();
    }

    // 생성 메서드 (CREATION METHOD)
    private Planet createPlanet(Money atomspherePrice,
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
