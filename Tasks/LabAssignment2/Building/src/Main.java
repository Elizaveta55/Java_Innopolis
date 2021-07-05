import building.Building;
import building.lift.AbstractLift;

public class Main {

    public static void main(String[] args){
        Building building = new Building();
        AbstractLift lift = building.createLift();
        AbstractLift superLift = building.createSuperLift();

        lift.goUpStairs(10);
        lift.goDownStairs(1);
        System.out.println(lift.getCurrentFloor());

        superLift.goUpStairs(10);
        superLift.goDownStairs(1);
        System.out.println(superLift.getCurrentFloor());
    }
}
