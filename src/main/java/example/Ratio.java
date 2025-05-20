package example;

public class Ratio {
    private double ratio;

    public Ratio(double ratio) {
        this.ratio = ratio;
    }

    public static Ratio from(double value) {
        return new Ratio(value);
    }

    public Ratio plus(Ratio other) {
        return new Ratio(this.ratio + other.ratio);
    }

    public double getRatio() {
        return ratio;
    }

    public boolean isOne() {
        return ratio == 1;
    }
}
