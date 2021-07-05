public class BMVAdapter extends Lada{
    private BMV bmv;

    public BMVAdapter(BMV bmv) {
        this.bmv = bmv;
    }

    @Override
    public void ride() {
        bmv.ride();
    }

    @Override
    public void eat(int fuel) {
        bmv.eat(fuel);
    }
}
