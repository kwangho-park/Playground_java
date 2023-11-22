package pkh.StrategePattern.robot.move;

/**
 * 이동방법에 대한 전략 구현 (walk)
 */
public class WalkingStrategy implements MovingStrategy {
    @Override
    public void move() { System.out.println("I can only walk."); }
}