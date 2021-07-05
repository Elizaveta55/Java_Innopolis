package pattern;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Im Windows Button, Im here");
    }

    @Override
    public void onClick() {
        System.out.println("Hello, Im Windows Button");
    }
}
