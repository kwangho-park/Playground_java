package pkh.StrategePattern.movable;

/**
 * 이동 전략을 설정하기위한 클래스
 */
public class Moving {
    private MovableStrategy movableStrategy;

    public void move(){
        movableStrategy.move();
    }

    // 객체를 생성하여 사용하는 시점에 이동 전략을 설정하는 메서드
    public void setMovableStrategy(MovableStrategy movableStrategy){
        this.movableStrategy = movableStrategy;
    }
}
