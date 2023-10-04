package pkh.utils;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Vector;

public class ByteUtil {

    public static long toLong(byte[] src, int srcOff)
    {
        long tot = 0;

        for (int i = srcOff; i < src.length; i++) {
            tot <<= 8;
            // tot += Integer.valueOf(i);
            // support 1.4 mod
            tot += (new Integer(src[i]).intValue());
        }

        return tot;
    }

    public static void longToBytes(byte[] dest, int destOff, long value)
    {
        for (int i = 0; i < 8; i++) {
            dest[i + destOff] = (byte) (value >> ((7 - i) * 8));
        }
    }

    public static int toInt(byte[] bytes)
    {
        return toInt(bytes, 0);
    }

    public static int toInt(byte[] src, int srcOff)
    {
        int tot = 0;

        for (int i = srcOff; i < src.length; i++) {
            tot <<= 8;
            // tot += Integer.valueOf(i);
            // support 1.4 mod
            tot += (new Integer(src[i]).intValue());
        }

        return tot;
    }

    public static int bytesToInt(byte[] src, int srcOff)
    {
        int word = 0;

        for (int i = 0; i <= 3; i++) {
            word = (word << 4) + (src[i + srcOff] & 0xff);
        }

        return word;
    }

    public static void intToBytes(byte[] dest, int destOff, int value)
    {
        for (int i = 0; i < 4; i++) {
            dest[i + destOff] = (byte) (value >> ((3 - i) * 8));
        }
    }

    public static boolean compareBytes(byte[] source, byte[] dest)
    {
        if (source.length != dest.length)
            return false;

        for (int i = 0; i < source.length; i++) {
            if (source[i] != dest[i])
                return false;
        }

        return true;
    }

    public static byte[] concatBytes(byte[] firstBytes, byte[] nextBytes)
    {
        byte[] bytes = new byte[firstBytes.length + nextBytes.length];

        System.arraycopy(nextBytes, 0, bytes, 0, nextBytes.length);
        System.arraycopy(firstBytes, 0, bytes, nextBytes.length, firstBytes.length);
        return bytes;
    }

    public static void splitBytes(byte[] source, byte[] firstBytes, byte[] nextBytes)
    {
        System.arraycopy(source, 0, firstBytes, 0, firstBytes.length);
        System.arraycopy(source, firstBytes.length, nextBytes, 0, nextBytes.length);
    }

    public static String toHexString(byte[] bytes)
    {
        StringBuffer sb = new StringBuffer(40);
        String hexstr;

        for (int i = 0; i < bytes.length; i++) {
            hexstr = Integer.toHexString(bytes[i]);
            if (hexstr.length() < 2)
                hexstr = "0" + hexstr;
            sb.append(hexstr.substring(hexstr.length() - 2));
        }

        return sb.toString();
    }

    public static byte[] toBytes(String bytestr)
    {
        byte[] bytes = new byte[bytestr.length() / 2];
        String hexstr;

        for (int i = 0; i < bytes.length; i++) {
            hexstr = bytestr.substring(i * 2, (i + 1) * 2);
            bytes[i] = (byte) Integer.parseInt(hexstr, 16);
        }

        return bytes;
    }

    public static byte[] getRandomNumber(int size)
    {
        byte[] byteRand = new byte[size];
        (new Random()).nextBytes(byteRand);

        return byteRand;
    }

    public static boolean equals(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
        if (paramArrayOfByte1 == paramArrayOfByte2)
            return true;

        if (paramArrayOfByte1.length != paramArrayOfByte2.length)
            return false;

        return equals(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
    }

    public static boolean a;

    public static boolean equals(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
    {
        boolean bool = a;
        int i = 0;

        do {
            if (i >= paramInt3)
                break;
            if (paramArrayOfByte1[(paramInt1 + i)] != paramArrayOfByte2[(paramInt2 + i)])
                return false;
            ++i;
        }
        while (!(bool));

        return true;
    }


    /**
     * SHA256 hash 알고리즘으로 암호화하는 함수 (by java.security lib)
     *
     * @param inputStr 암호화 대상 plane data
     * @return sha256 암호화된 hex string data (64byte)
     * @throws Exception
     */
    public static String getHashValue(String inputStr) throws Exception
    {
        byte[] byteArray = inputStr.getBytes();

        MessageDigest md = null;			// MessageDigest (메세지 소화) : 단방향 해시 암호화 라이브러리 (java.security package)
        md = MessageDigest.getInstance("SHA-256");

        if (md == null)
            return null;

        md.reset();
        md.update(byteArray);

        byte digest[] = md.digest();

        StringBuffer buffer = new StringBuffer();


        for (int i = 0; i < digest.length; i++) {

            // test log
            System.out.print("buffer (hexString) : "+buffer.toString() +" / ");
            System.out.print("digest: "+digest[i] +" / ");
            System.out.print("Hex (0xFF & digest ) ) : "+Integer.toHexString(0xF & digest[i]) +" / ");
            System.out.println("Hex length : "+Integer.toHexString(0xF & digest[i]).length());

            // 0xFF & [byte] 이유 : byte 값을 0x00 ~0xFF (즉 max 2byte)까지로 제한하여 일관된 해시값을 얻기위함
            // ex 0xF & [byte] 인 경우 0x0 ~ 0xF (1byte) 까지의 해시값 반환
            if (Integer.toHexString(0xF & digest[i]).length() == 1)
                buffer.append("0" + Integer.toHexString(0xF & digest[i]));
            else
                buffer.append(Integer.toHexString(0xF & digest[i]));


        }

        return buffer.toString();
    }

    public static String[] splitString(String str, String del)
    {
        StringTokenizer st = new StringTokenizer(str, del);
        ArrayList<String> arrlist = new ArrayList<String>();

        while (st.hasMoreTokens())
            arrlist.add(st.nextToken().trim());

        String[] results = new String[arrlist.size()];
        arrlist.toArray(results);

        return results;
    }

    public static String[] getSplit(String strString, String strDelimeter)
    {
        Vector<String> vResult = new Vector<String>();
        int nLastIndex = 0;

        try {
            nLastIndex = strString.indexOf(strDelimeter);

            if (nLastIndex == -1) {
                vResult.addElement(strString);
            } else {
                while ((strString.indexOf(strDelimeter) > -1)) {
                    nLastIndex = strString.indexOf(strDelimeter);
                    vResult.addElement(strString.substring(0, nLastIndex).trim());
                    strString = strString.substring(nLastIndex + strDelimeter.length(), strString.length());
                }

                vResult.addElement(strString);
            }
        } catch (Exception e) {
            System.out.println("getSplit() - Exception : " + e.getMessage());
            return null;
        }

        String[] value = new String[vResult.size()];
        vResult.copyInto(value);

        return value;
    }

}
