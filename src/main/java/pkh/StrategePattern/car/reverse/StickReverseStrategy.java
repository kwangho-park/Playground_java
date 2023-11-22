package pkh.StrategePattern.car.reverse;

public class StickReverseStrategy implements ReverseStrategy{
    @Override
    public void reverse(){
        System.out.println("클러치를 밟는다.");
        System.out.println("기어를 R로 변속한다.");
        System.out.println("클러치에서 발을 떼고 엑셀을 밟는다.");
    }
}
