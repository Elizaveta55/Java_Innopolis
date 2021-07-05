package pattern;

public class WindowsLabel implements Label {
    @Override
    public void show() {
        System.out.println("Showing Win label");
    }

    @Override
    public void initial() {
        System.out.println("Initial Win label value");
    }
}
