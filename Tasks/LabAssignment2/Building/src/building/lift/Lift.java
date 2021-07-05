package building.lift;

import building.Building;
import building.INotifier;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class Lift extends AbstractLift implements IMusic {

    public Lift(INotifier iNotifier){
        super(iNotifier);
    }

    @Override
    public void turnOnMusic() {
        System.out.println("turn music on");
    }

    @Override
    public void turnOffMusic() {
        System.out.println("turn music off");
    }

}
