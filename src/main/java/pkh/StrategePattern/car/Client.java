package pkh.StrategePattern.car;

import pkh.StrategePattern.car.car.AutoCar;
import pkh.StrategePattern.car.car.Car;
import pkh.StrategePattern.car.car.StickCar;
import pkh.StrategePattern.car.changeGear.AutoGearStrategy;
import pkh.StrategePattern.car.changeGear.StickGearStrategy;
import pkh.StrategePattern.car.reverse.AutoReverseStrategy;
import pkh.StrategePattern.car.reverse.StickReverseStrategy;
import pkh.StrategePattern.car.start.AutoStartStrategy;
import pkh.StrategePattern.car.start.StickStartStrategy;

public class Client {
    /**
     *
     * @param car 자동차 종류 ("stick" or "auto")
     */
    public void client(String car){

        if(car.equals("stick")){

            System.out.println("--수동 변속기 차량의 동작--");
            Car stickCar = new StickCar();
            stickCar.setStartStrategy(new StickStartStrategy());
            stickCar.setGearStrategy(new StickGearStrategy());
            stickCar.setReverseStrategy(new StickReverseStrategy());

            stickCar.start();   // 시동 
            stickCar.gear();    // 기어변속
            stickCar.reverse(); // 후진

        }else if(car.equals("auto")){
            System.out.println("--자동 변속기 차량의 동작--");

            Car autoCar = new AutoCar();
            autoCar.setStartStrategy(new AutoStartStrategy());
            autoCar.setGearStrategy(new AutoGearStrategy());
            autoCar.setReverseStrategy(new AutoReverseStrategy());

            autoCar.start();
            autoCar.gear();
            autoCar.reverse();
        }


    }
}
