package building.lift;

import building.Building;
import building.INotifier;

public abstract class AbstractLift {
    protected final INotifier notifier;

    protected int currentFloor = 1;

    public AbstractLift(INotifier iNotifier){
        this.notifier = iNotifier;
    }

    public int getCurrentFloor()
    {
        return this.currentFloor;
    }

    public void goUpStairs(int amountOfFloorsUp){
        if (this.currentFloor + amountOfFloorsUp >= Building.getMaxFloor()) throw new IllegalArgumentException("To big value of amount of floors");
        this.currentFloor += amountOfFloorsUp;

        if (this.currentFloor >= Building.getMaxFloor()) throw new IllegalArgumentException("To big value of amount of floors");
        this.notifier.Notify(this.currentFloor);
    }

    public void goDownStairs(int amountOfFloorsUp){
        if (this.currentFloor - amountOfFloorsUp <= 1) throw new IllegalArgumentException("To small value of amount of floors");

        this.currentFloor -= amountOfFloorsUp;

        if (this.currentFloor <= 1) throw new IllegalArgumentException("To big value of amount of floors");
        this.notifier.Notify(this.currentFloor);
    }

}
