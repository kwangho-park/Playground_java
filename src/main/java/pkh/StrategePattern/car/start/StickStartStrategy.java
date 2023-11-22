package pkh.StrategePattern.car.start;

/**
 * 수동 시동에 대한 전략 구현
 */
public class StickStartStrategy implements StartStrategy{
    @Override
    public void start(){
        System.out.println("클러치와 브레이크를 동시에 밟는다.");
        System.out.println("시동을 건다.");
    }
}
