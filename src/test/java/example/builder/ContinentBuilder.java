package example.builder;

import example.Continent;
import example.Nation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static example.Money.*;
import static example.builder.NationBuilder.aNation;

public class ContinentBuilder {
    private String name;
    private List<Nation> nations = Arrays.asList(aNation().with("대한민국").with(wons(1000)).build(),
            aNation().with("일본").with(wons(1000)).build());

    public static ContinentBuilder aContinent() {
        return new ContinentBuilder();
    }

    public ContinentBuilder with(String name) {
        this.name = name;
        return this;
    }

    @Deprecated
    public ContinentBuilder with(Nation... nations) {
        this.nations = Arrays.asList(nations);
        return this;
    }

    // 클라이언트에서 aNation().build()를 직접 호출할 필요 없어짐
    public ContinentBuilder with(NationBuilder... nations) {
        this.nations = new ArrayList<>();

        for(NationBuilder each : nations) {
            this.nations.add(each.build());
        }

        return this;
    }

    public Continent build() {
        return new Continent(name, nations);
    }
}
