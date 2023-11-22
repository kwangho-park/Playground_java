package pkh.StrategePattern.car.start;

/**
 * 자동 시동에 대한 전략 구현
 */
public class AutoStartStrategy implements StartStrategy{

    @Override
    public void start(){
        System.out.println("브레이크를 밟는다.");
        System.out.println("시동을 건다.");
    }
}
