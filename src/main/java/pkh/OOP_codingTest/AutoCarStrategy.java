package pkh.OOP_codingTest;

/**
 * 자동 차량의 동작 전략
 * (구현)
 */
public class AutoCarStrategy implements TransmissionStrategy{

    @Override
    public void start(){
        System.out.println("브레이크를 밟는다.");
        System.out.println("시동을 건다.");
    }
    @Override
    public void changeGear(){
        System.out.println("엑셀을 밟아서 속도를 올리거나 브레이크 밟아서 속도를 줄인다.");
    }

    @Override
    public void reverse(){
        System.out.println("브레이크를 밟는다.");
        System.out.println("변속기를 R로 변속한다.");
        System.out.println("브레이크를 뗀다.");
        System.out.println("엑셀을 밟는다.");
    }



}
