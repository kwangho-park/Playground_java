package pkh.StrategePattern.robot.attack;

/**
 * 공격방법에 대한 전략 구현  (펀치)
 */
public class PunchStrategy implements AttackStrategy {
    @Override
    public void attack(){
        System.out.println("I have strong punch.");
    }
}
