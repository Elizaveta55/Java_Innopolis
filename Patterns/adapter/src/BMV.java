public class BMV implements ICar{
    public String rate;

    @Override
    public void ride() {
        System.out.println("Im riding on BMV");
    }

    @Override
    public void eat(int fuel) {
        System.out.println("BMV need " + fuel);
    }
}
