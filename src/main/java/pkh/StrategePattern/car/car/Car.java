package pkh.StrategePattern.car.car;

import pkh.StrategePattern.car.changeGear.GearStrategy;
import pkh.StrategePattern.car.reverse.ReverseStrategy;
import pkh.StrategePattern.car.start.StartStrategy;

public class Car {
    private StartStrategy startStrategy;
    private GearStrategy gearStrategy;
    private ReverseStrategy reverseStrategy;

    public void start(){
        startStrategy.start();
    }
    public  void gear(){
        gearStrategy.changeGear();
    }

    public void reverse(){
        reverseStrategy.reverse();
    }

    public void setStartStrategy(StartStrategy startStrategy){
        this.startStrategy = startStrategy;
    }

    public void setGearStrategy(GearStrategy gearStrategy){
        this.gearStrategy = gearStrategy;
    }

    public void setReverseStrategy(ReverseStrategy reverseStrategy){
        this.reverseStrategy = reverseStrategy;
    }
}
