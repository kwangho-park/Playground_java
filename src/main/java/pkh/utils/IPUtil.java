package pkh.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPUtil {

	public static String getIpAddr(HttpServletRequest request) throws UnknownHostException {
        String ip = null;
        
        if(request != null){
        	ip = request.getHeader("X-Forwarded-For");
            
            if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {  
                ip = request.getHeader("Proxy-Client-IP");  
            }  
            if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {  
                ip = request.getHeader("WL-Proxy-Client-IP");  
            }  
            if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {  
                ip = request.getHeader("HTTP_CLIENT_IP");  
            }  
            if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {  
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
            }  
            if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {  
                ip = request.getRemoteAddr();  
            }
            
            if(ip.equals("0:0:0:0:0:0:0:1")){
    			InetAddress ipAddress =  InetAddress.getLocalHost();
    			ip = ipAddress.getHostAddress();
    		}
        }
        
        return ip;  
    }
	


	/**
	 * 
 	 * @param ipRangeFilePath : IP, CIDR 가 나열된 파일 
	 * @param input
	 * @return
	 * @throws UnknownHostException
	 * @throws PropertyControlException
	 */	
	public static boolean validateIP(String ipRangeFilePath, String input) throws UnknownHostException {
		try {
			
			BufferedReader in = new BufferedReader(new FileReader(ipRangeFilePath));
			String range;

			while ((range = in.readLine()) != null) {
				String[] tmp = range.split("/");
				String match = tmp[0];
				int netMask = 32;
				if (tmp.length == 2) {
					try {
						netMask = Integer.parseInt(tmp[1]);
					} catch (NumberFormatException e) {}
				}

				int mask = -1 << (32 - netMask);
				
				int subnet = 0;
				try {
					subnet = stringIPToInt(match);
				} catch (UnknownHostException e) {
					continue;
				}
				int ip = stringIPToInt(input);
				
				if ((subnet & mask) == (ip & mask)) {
				    return true;
				}
			}
			
		} catch (UnknownHostException e) {
			throw new UnknownHostException("접근 IP를 확인할 수 없음");
		} 
		
		return false;
	}
	
	private static int stringIPToInt(String input) throws UnknownHostException {
		Inet4Address i4adds = (Inet4Address) InetAddress.getByName(input);
		byte[] b = i4adds.getAddress();
		int ip = ((b[0] & 0xFF) << 24) |
				((b[1] & 0xFF) << 16) |
				((b[2] & 0xFF) << 8)  |
				((b[3] & 0xFF) << 0);
		return ip;
	}

}
