package example.builder;

import example.Element;
import example.Ratio;

public class ElementBuilder {
    private String name = "원소";
    private Ratio ratio = Ratio.from(0.1);

    public static ElementBuilder anElement() {
        return new ElementBuilder();
    }

    public ElementBuilder with(String name) {
        this.name = name;
        return this;
    }

    public ElementBuilder with(Ratio ratio) {
        this.ratio = ratio;
        return this;
    }

    public Element build() {
        return Element.of(name, ratio);
    }
}
