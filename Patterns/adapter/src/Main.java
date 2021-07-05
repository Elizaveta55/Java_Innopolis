public class Main {

    public static void main(String[] args) {
        BMV bmv = new BMV();
        Lada lada = new Lada();
        bmv.ride();
        bmv.eat(15);
        lada.ride();
        lada.eat(75);

        BMV bmvlike = new BMV();

        BMVAdapter bmvAdapter = new BMVAdapter(bmvlike);
        bmvAdapter.eat(80);
        bmvAdapter.ride();
    }
}
