package pkh.StrategePattern.robot.robot;

import pkh.StrategePattern.robot.attack.AttackStrategy;
import pkh.StrategePattern.robot.move.MovingStrategy;

/**
 * 로봇을 생성하기 위한 클래스 (전략 생성)
 */
public abstract class Robot {
    private String name;
    private AttackStrategy attackStrategy;      // 공격전략 구현
    private MovingStrategy movingStrategy;      // 이동전략 구현

    // 생성자
    public Robot(String name) { this.name = name; }

    public String getName() { return name; }

    public void attack() { attackStrategy.attack(); }
    public void move() { movingStrategy.move(); }

    // 집약 관계, 전체 객체가 메모리에서 사라진다 해도 부분 객체는 사라지지 않는다.
    // setter 메서드
    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy; }
    public void setMovingStrategy(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy; }
}
