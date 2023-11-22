package pkh.StrategePattern.car.changeGear;

public class StickGearStrategy implements GearStrategy{
    @Override
    public void changeGear(){
        System.out.println("클러치를 밟는다.");
        System.out.println("기어를 변속한다.");
        System.out.println("클러치에서 발을 떼고 엑셀을 밟는다.");
    }

}
