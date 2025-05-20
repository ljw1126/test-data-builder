package example;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

// 행성 (핵심 도메인)
public class Planet {
    private Atomsphere atomsphere; // 대기
    private List<Continent> continents; // 대륙
    private List<Ocean> oceans; // 바다

    public Planet(Atomsphere atomsphere, List<Continent> continents, List<Ocean> oceans) {
        this.atomsphere = atomsphere;
        this.continents = continents;
        this.oceans = oceans;
        assertValid();
    }

    private void assertValid() {
        if(continents.size() < 1) {
            throw new IllegalArgumentException("대륙은 1개 이상 존재해야 합니다");
        }

        if(oceans.size() < 1) {
            throw new IllegalArgumentException("대양은 1개 이상 존재해야 합니다");
        }
    }

    public Collection<Continent> getContinents() {
        return Collections.unmodifiableCollection(continents);
    }

    public Collection<Ocean> getOceans() {
        return Collections.unmodifiableCollection(oceans);
    }

    // 행성의 제조가격
    public Money getPrice() {
        return atomsphere.getPrice().plus(getContinentsPrice()).plus(getOceansPrice());
    }

    private Money getOceansPrice() {
        Money result = Money.wons(0);
        for(Ocean each : oceans) {
            result = result.plus(each.getPrice());
        }

        return result;
    }

    private Money getContinentsPrice() {
        Money result = Money.wons(0);
        for(Continent each : continents) {
            result = result.plus(each.getPrice());
        }

        return result;
    }
}
