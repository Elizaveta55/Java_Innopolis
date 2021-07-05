package pattern;

public class HTMLFactory implements AbstractFactory {
    @Override
    public Label createLabel() {
        return new HTMLLabel();
    }

    @Override
    public Button createButton() {
        return new HTMLButton();
    }
}
