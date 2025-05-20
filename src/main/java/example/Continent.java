package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 대륙
public class Continent {
    private String name;
    private List<Nation> nations = new ArrayList<>(); // 국가 목록

    public Continent(String name) {
        this(name, Collections.emptyList());
    }

    public Continent(String name, Nation... nations) {
        this(name, Arrays.asList(nations));
    }

    public Continent(String name, List<Nation> nations) {
        this.name = name;
        this.nations = nations;
    }

    public Money getPrice() {
        Money result = Money.wons(0);
        for(Nation each : nations) {
            result = result.plus(each.getPrice());
        }
        return result;
    }
}
