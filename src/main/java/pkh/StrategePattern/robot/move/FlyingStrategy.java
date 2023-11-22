package pkh.StrategePattern.robot.move;

/**
 * 이동방법에 대한 전략 구현 (fly)
 */
public class FlyingStrategy implements MovingStrategy{
    @Override
    public void move(){
        System.out.println("I can fly.");
    }
}
