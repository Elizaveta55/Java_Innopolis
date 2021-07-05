public class Lada implements ICar {
    public String rate;

    @Override
    public void ride() {
        System.out.println("Im riding on Lada");
    }

    @Override
    public void eat(int fuel) {
        System.out.println("Lada need " + fuel);
    }
}
