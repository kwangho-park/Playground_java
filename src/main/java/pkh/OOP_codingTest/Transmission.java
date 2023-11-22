package pkh.OOP_codingTest;

/**
 * 변속기 전략을 위한 클래스 (수동/자동)
 */
public class Transmission {

    private TransmissionStrategy transmissionStrategy;

    public void start(){
        transmissionStrategy.start();
    }

    public void changeGear(){
        transmissionStrategy.changeGear();
    }

    public void reverse(){
        transmissionStrategy.reverse();
    }

    public void setTransmissionStrategy(TransmissionStrategy transmissionStrategy){
        this.transmissionStrategy = transmissionStrategy;
    }
}
