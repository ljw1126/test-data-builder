package example.builder;

import example.Atomsphere;
import example.Element;
import example.Money;
import example.Ratio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static example.builder.ElementBuilder.*;

public class AtomsphereBuilder {
    private Money price = Money.wons(1000);
    private List<Element> elements = Arrays.asList(anElement().with("N").with(Ratio.from(0.8)).build(),
            anElement().with("0").with(Ratio.from(0.2)).build());

    public static AtomsphereBuilder anAtomsphere() {
        return new AtomsphereBuilder();
    }

    public AtomsphereBuilder with(Money price) {
        this.price = price;
        return this;
    }

    @Deprecated
    public AtomsphereBuilder with(Element... elements) {
        this.elements = Arrays.asList(elements);
        return this;
    }

    // 마찬가지로 클라이언트에서 anElement().build()를 직접 호출할 필요 없어짐
    public AtomsphereBuilder with(ElementBuilder... elements) {
        this.elements = new ArrayList<>();
        for(ElementBuilder each : elements) {
            this.elements.add(each.build());
        }

        return this;
    }

    public Atomsphere build() {
        return new Atomsphere(price, elements);
    }
}
