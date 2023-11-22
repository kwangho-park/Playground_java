package pkh.OOP_codingTest;


/**
 * 사용자 A 가 수동 변속기의 차량과 자동 변속기의 차량 운행(시동, 기어 변속, 주행, 후진)을 설계 및 구현
 *
 */
public class Client {

    /**
     *
     * @param car 차량종류 : "manual" or "auto"
     */
    public void client(String car){

        // java 객체 지향 코딩테스트 (Strategy 사용)
        // 사용자가 수동 변속기의 차량과 자동 변속기의 차량 운행(시동, 기어 변속, 주행, 후진)을 설계 및 구현
        // (필수 사항 : 역할과 구현을 분리하여 설계 그리고 디자인 패턴 활용)

        if(car.equals("manual")){
            System.out.println("==수동 차량의 동작== ");

            Transmission manualCar = new ManualCar();
            manualCar.setTransmissionStrategy(new ManualCarStrategy());

            System.out.println("--시동--");
            manualCar.start();
            System.out.println("--기어 변속--");
            manualCar.changeGear();
            System.out.println("--후진--");
            manualCar.reverse();

        }else if(car.equals("auto")){
            System.out.println("==자동 차량의 동작== ");

            Transmission autoCar = new AutoCar();
            autoCar.setTransmissionStrategy(new AutoCarStrategy());
            System.out.println("--시동--");
            autoCar.start();
            System.out.println("--기어 변속--");
            autoCar.changeGear();
            System.out.println("--후진--");
            autoCar.reverse();

        }

    }
}
