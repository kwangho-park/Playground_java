package pkh.OOP_codingTest;

/**
 * 변속기 동작 전략
 * (역할 정의)
 */
public interface TransmissionStrategy {

    // 시동
    public void start();

    // 기어변속
    public void changeGear();


    // 후진
    public void reverse();
}
