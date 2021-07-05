package building;


import building.lift.AbstractLift;
import building.lift.Lift;
import building.lift.SuperLift;

// Responsible for managing lifts
public class Building implements ICreateLift, ICreateSuperLift{

    private static final int maxFloor = 20;

    public static int getMaxFloor(){
        return Building.maxFloor;
    }

    @Override
    public AbstractLift createLift(){
        AbstractLift lift = new Lift(new Notifier());
        return lift;
    }

    @Override
    public AbstractLift createSuperLift(){
        AbstractLift lift = new SuperLift(new Notifier());
        return lift;
    }

}
