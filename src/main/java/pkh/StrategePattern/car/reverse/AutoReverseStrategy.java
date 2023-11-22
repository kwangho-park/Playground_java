package pkh.StrategePattern.car.reverse;

public class AutoReverseStrategy implements ReverseStrategy{
    @Override
    public void reverse(){
        System.out.println("브레이크를 밟는다.");
        System.out.println("기어를 R로 변속한다.");
        System.out.println("브레이크를 뗀다.");
        System.out.println("엑셀을 밟는다.");
    }
}
