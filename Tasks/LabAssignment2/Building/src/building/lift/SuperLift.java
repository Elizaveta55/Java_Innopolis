package building.lift;

import building.Building;
import building.INotifier;


public class SuperLift extends Lift implements IWiFi {

    public SuperLift(INotifier iNotifier) {
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

    @Override
    public void connectToWiFi() {
        System.out.println("Connect to WiFi");
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
