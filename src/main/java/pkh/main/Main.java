package pkh.main;

import pkh.utils.ByteUtil;
import pkh.constants.RESULT;

public class Main {
    public static void main(String[] args) {

        // 열거형 테스트
        System.out.println("열거형(enum) 테스트");

        RESULT result = null;
        result = RESULT.SUCCESS;

        System.out.println("열거형 타입 변수 정의 및 데이터 입력 테스트 : "+result);


    }
}