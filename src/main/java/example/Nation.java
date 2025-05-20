package example;

// 국가
public class Nation {
    private String name;
    private Money price; // 제조 가격

    public Nation(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }
}
