package pattern;

public class Main {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new HTMLFactory();
        abstractFactory.createButton().onClick();
        abstractFactory.createLabel().initial();
    }
}
