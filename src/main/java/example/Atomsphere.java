package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 대기
public class Atomsphere {
    private Money price;
    private List<Element> elements = new ArrayList<>();

    public Atomsphere(Money price, Element... elements) {
        this(price, Arrays.asList(elements));
    }

    public Atomsphere(Money price, List<Element> elements) {
        this.price = price;
        this.elements = elements;
        assertElements();
    }

    private void assertElements() {
        checkElementRatio();
        checkElementSize();
    }

    private void checkElementSize() {
        if(elements.size() < 2) {
            throw new IllegalArgumentException("대기는 적어도 2개 이상의 원소로 구성되어야 합니다");
        }
    }

    private void checkElementRatio() {
        if(!accumulateRatio().isOne()) {
            throw new IllegalArgumentException("전체 원소의 비율 총합은 1이어야 합니다");
        }
    }

    private Ratio accumulateRatio() {
        Ratio result = Ratio.from(0);
        for(Element element : elements) {
            result = result.plus(element.getRatio());
        }

        return result;
    }

    public Money getPrice() {
        return price;
    }
}
