package example;

public class Ratio {
    private int ratio;

    public Ratio(int ratio) {
        this.ratio = ratio;
    }

    public static Ratio from(int value) {
        return new Ratio(value);
    }

    public Ratio plus(Ratio other) {
        return new Ratio(this.ratio + other.ratio);
    }

    public int getRatio() {
        return ratio;
    }

    public boolean isOne() {
        return ratio == 1;
    }
}
