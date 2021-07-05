package pattern;

public class HTMLLabel implements Label {
    @Override
    public void show() {
        System.out.println("Showing HTML label");
    }

    @Override
    public void initial() {
        System.out.println("Initial HTML label value");
    }
}
