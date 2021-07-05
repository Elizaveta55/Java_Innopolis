package building;

public class Notifier implements INotifier{


    public Notifier() { }

    @Override
    public void Notify(int floor){
        System.out.println("Current floor is " + new Integer(floor).toString());
    }
}
