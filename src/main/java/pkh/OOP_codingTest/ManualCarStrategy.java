package pkh.OOP_codingTest;

/**
 * 수동 차량의 전략
 * (구현)
 */
public class ManualCarStrategy implements TransmissionStrategy{


    @Override
    public void start(){
        System.out.println("클러치와 브레이크를 동시에 밟는다");
        System.out.println("시동을 건다");
    }

    @Override
    public void changeGear(){
        System.out.println("클러치를 밝는다");
        System.out.println("기어를 변속한다");
        System.out.println("클러치에서 발을 떼고 엑셀을 밟는다.");
    }

    @Override
    public void reverse(){
        System.out.println("클러치를 밟는다.");
        System.out.println("기어를 R로 변속한다.");
        System.out.println("클러치에서 발을 떼고 엑셀을 밟는다.");
    }


}
