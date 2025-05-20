package example;

// 대양 (바다는 대양들의 집합으로 추상화할 수 있다)
public class Ocean {
    private String name;
    private Money price; // 제조 가격

    public Ocean(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }
}
