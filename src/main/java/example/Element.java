package example;

// 대기를 구성하는 원소
public class Element {
    private String name;
    private Ratio ratio;

    public Element(String name, Ratio ratio) {
        this.name = name;
        this.ratio = ratio;
    }

    public static Element of(String name, Ratio ratio) {
        return new Element(name, ratio);
    }

    public String getName() {
        return name;
    }

    public Ratio getRatio() {
        return ratio;
    }
}
