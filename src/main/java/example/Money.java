package example;

public class Money {
    private int value;

    public Money(int value) {
        this.value = value;
    }

    public static Money wons(int value) {
        return new Money(value);
    }

    public Money plus(Money money) {
        return new Money(this.value + money.value);
    }

    public boolean isGraterThanOrEqual(Money money) {
        return this.value >= money.value;
    }
}
