package pkh.main;


/**
 * 간단한 코딩 테스트 확인용
 */
public class CodingTest {

    // 소수 확인
    // 소수 : 1과 자기 자신만 약수로 가지는 수
    // 약수 ; 어떤 수를 나누어 떨어지게 하는 수 (=나누어 떨어지다 == 나머지 값 0)
    // 3.5.7.11,13
    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
