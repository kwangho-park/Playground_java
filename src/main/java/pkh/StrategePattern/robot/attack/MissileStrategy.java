package pkh.StrategePattern.robot.attack;

/**
 * 공격방법에 대한 전략 구현  (미사일)
 */
public class MissileStrategy implements AttackStrategy {
    @Override
    public void attack(){
        System.out.println("I have Missile");
    }
}
