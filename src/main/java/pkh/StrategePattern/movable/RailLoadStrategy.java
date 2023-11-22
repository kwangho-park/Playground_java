package pkh.StrategePattern.movable;

/**
 * 선로 이동 전략
 */
public class RailLoadStrategy implements MovableStrategy{

    @Override
    public void move(){
        System.out.println("선로를 통해 이동");
    }

}
