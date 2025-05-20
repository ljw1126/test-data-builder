package example;

public class Money {
    private long value;

    public Money(long value) {
        this.value = value;
    }

    public static Money wons(long value) {
        return new Money(value);
    }

    public Money plus(Money money) {
        return new Money(this.value + money.value);
    }

    public boolean isGraterThanOrEqual(Money money) {
        return this.value >= money.value;
    }
}
