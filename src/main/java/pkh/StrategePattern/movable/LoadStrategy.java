package pkh.StrategePattern.movable;

/**
 * 도로 이동 전략
 */
public class LoadStrategy implements MovableStrategy{

    @Override
    public void move(){
        System.out.println("도로를 통해 이동");
    }
}
