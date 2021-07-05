package pattern;

public class WindowsFactory implements AbstractFactory {
    @Override
    public Label createLabel() {
        return new WindowsLabel();
    }

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
