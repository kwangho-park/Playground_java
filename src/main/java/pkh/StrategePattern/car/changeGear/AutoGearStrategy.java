package pkh.StrategePattern.car.changeGear;

public class AutoGearStrategy implements GearStrategy{
    @Override
    public void changeGear(){
        System.out.println("엑셀을 밟아서 속도를 올리거나 브레이크 밟아서 속도를 줄인다.");
    }

}
