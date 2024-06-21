package pkh.StrategePattern.robot;

import pkh.StrategePattern.robot.attack.MissileStrategy;
import pkh.StrategePattern.robot.attack.PunchStrategy;
import pkh.StrategePattern.robot.move.FlyingStrategy;
import pkh.StrategePattern.robot.move.WalkingStrategy;
import pkh.StrategePattern.robot.robot.Atom;
import pkh.StrategePattern.robot.robot.Robot;
import pkh.StrategePattern.robot.robot.TaekwonV;

public class Client {
    public void client (){

        Robot taekwonV = new TaekwonV("TaekwonV");      // 수동 차량
        Robot atom = new Atom("Atom");                  // 자동 차량

        /* 수정된 부분: 전략 변경 방법 */
        taekwonV.setMovingStrategy(new WalkingStrategy());      // 시동 (수동 or 자동)
        taekwonV.setAttackStrategy(new MissileStrategy());      // 기어변속 (수동 or 자동)
        atom.setMovingStrategy(new FlyingStrategy());
        atom.setAttackStrategy(new PunchStrategy());

        /* 아래부터는 동일 */
        System.out.println("My name is " + taekwonV.getName());
        taekwonV.move();
        taekwonV.attack();

        System.out.println();
        System.out.println("My name is " + atom.getName());
        atom.move();
        atom.attack();
        System.out.println("test");
        System.out.println("test");
    }
}
