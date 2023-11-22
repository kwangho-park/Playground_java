package pkh.StrategePattern.movable;

/**
 * Stratege Pattern 의 예시 <br>
 * 전략 패턴
 *
 */
public class Client {

    public void client(){

        // OCP 위배 예시
        // Train, Bus 클래스가 move() 함수가 정의된 Movable 인터페이스를 상속받은 상태
        // 선로를 통해 이동하는 버스가 개발되는경우 bus의 멤버함수를 변경해야함
//        Movable train = new Train();
//        Movable bus = new Bus();
//
//        train.move();
//        train.move();


        Moving train = new Train();
        Moving bus = new Bus();

        // 기존의 기차와 버스의 이동방식
        // 기차 : 선로 , 버스 : 도로
        train.setMovableStrategy(new RailLoadStrategy());
        bus.setMovableStrategy(new LoadStrategy());

        train.move();
        bus.move();

        // 선로를 따라 이동하는 버스가 개발됨
        bus.setMovableStrategy(new RailLoadStrategy());
        bus.move();

    }
}
