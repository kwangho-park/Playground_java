import org.junit.Test;
import pkh.utils.ByteUtil;

public class ByteUtilTest {

    @Test
    public void getHashValue(){

        try{
            System.out.println("Hash 암호화 테스트");
            // given
            String data = "planeData";

            // when
            String hashString  = ByteUtil.getHashValue("planeData");

            // then
            System.out.println("Hash 암호화 결과 : "+hashString);

        }catch(Exception e){
            e.printStackTrace();
        }



    }
}
