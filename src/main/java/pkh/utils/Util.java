package kr.com.dreamsecurity.hotp.util;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import com.dreamsecurity.jcaos.util.encoders.Base64;


public class Util
{

	public static boolean isEmpty(String str)
	{
		return str == null || str.equals("");
	}

	public static String getURL(HttpServletRequest request, String path)
	{
		URL returnURL = null;

		try {
			returnURL = new URL(path);
		}
		catch (MalformedURLException e) {
			int sport = request.getServerPort();

			try {
				if (sport == 80)
					returnURL = new URL(request.getScheme() + "://" + request.getServerName() + path);
				else
					returnURL = new URL(request.getScheme() + "://" + request.getServerName() + ":" + sport + path);
			}
			catch (Exception ex) {
				if (sport == 80)
					return request.getScheme() + "://" + request.getServerName() + "/" + path;
				else
					return request.getScheme() + "://" + request.getServerName() + ":" + sport + "/" + path;
			}
		}

		return returnURL.toString();
	}


	public static long getTime()
	{
		return System.currentTimeMillis();
	}

	public static String getDateFormat(String format)
	{
		DateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}

	public static String addDate(String baseDate, String pattern, int field, int amount)
	{
		String result = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Calendar calendar = Calendar.getInstance();

		try {
			calendar.setTime(dateFormat.parse(baseDate));
			calendar.add(field, amount);
			result = dateFormat.format(calendar.getTime());
		}
		catch (ParseException e) {
			result = baseDate;
		}

		return result;
	}

	public static String getServerIP()
	{
		StringBuffer sb = new StringBuffer();

		try {
			Class<?> CNetworkInterface = Class.forName("java.net.NetworkInterface");
			Method getNetworkInterfaces = CNetworkInterface.getMethod("getNetworkInterfaces", null);
			Enumeration ifaces = (Enumeration) getNetworkInterfaces.invoke(CNetworkInterface, null);

			for (; ifaces.hasMoreElements();) {
				Object oNetworkInterface = ifaces.nextElement();
				InetAddress ia = null;
				Method getInetAddresses = oNetworkInterface.getClass().getMethod("getInetAddresses", null);
				Enumeration ips = (Enumeration) getInetAddresses.invoke(oNetworkInterface, null);

				for (; ips.hasMoreElements();) {
					ia = (InetAddress) ips.nextElement();
					String hostAddress = ia.getHostAddress();

					// IP v4 형태의 HostAddress 만을 획득하기 위함
					if (hostAddress.indexOf('.') != -1)
						if (!hostAddress.equals("127.0.0.1"))
							sb.append(hostAddress + ";");
				}
			}
		}
		catch (ClassNotFoundException e) {
			try {
				InetAddress[] ias = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());

				// ipv6 ip 는 SKIP (ipv6 는 길이가 15 가 넘음)
				for (int i = 0; i < ias.length; i++) {
					if (ias[i].getHostAddress().length() <= 15)
						if (!ias[i].getHostAddress().equals("127.0.0.1"))
							sb.append(ias[i].getHostAddress() + ";");
				}
			}
			catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

	public static String getBaseURL(HttpServletRequest request)
	{
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	}

	public static String domToStr(Document doc, boolean indent)
	{
		try {
			DOMSource domSource = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();

			String encoding = new OutputStreamWriter(System.out).getEncoding();

			if (!"UTF8".equals(encoding)) {
				transformer.setOutputProperty(OutputKeys.ENCODING, "EUC-KR");
			}

			if (indent) {
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			}

			transformer.transform(domSource, result);
			return writer.toString();
		}
		catch (TransformerException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static String domToStr(Document doc, boolean indent, String encoding)
	{
		try {
			DOMSource domSource = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();

			transformer.setOutputProperty(OutputKeys.ENCODING, encoding);

			if (indent) {
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			}

			transformer.transform(domSource, result);
			return writer.toString();
		}
		catch (TransformerException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Document createDomDoc(String xmlString)
	{
		DocumentBuilderFactory objDocBuilderFactory = DocumentBuilderFactory.newInstance();
		objDocBuilderFactory.setNamespaceAware(true);

		try {
			DocumentBuilder objDocBuilder = objDocBuilderFactory.newDocumentBuilder();
			return objDocBuilder.parse(new ByteArrayInputStream(xmlString.getBytes()));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Document createDomDoc(byte[] xmlByte)
	{
		DocumentBuilderFactory objDocBuilderFactory = DocumentBuilderFactory.newInstance();
		objDocBuilderFactory.setNamespaceAware(true);

		try {
			DocumentBuilder objDocBuilder = objDocBuilderFactory.newDocumentBuilder();
			return objDocBuilder.parse(new ByteArrayInputStream(xmlByte));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static X509Certificate getCert(String certFilepath)
	{
		try {
			InputStream pubKey = new FileInputStream(certFilepath);
			CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");

			return (X509Certificate) certificateFactory.generateCertificate(pubKey);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String getAttribute(HttpServletRequest request, String key)
	{
		String result = request.getAttribute(key) == null ? "" : (String) request.getAttribute(key);

		if (isEmpty(result)) {
			result = request.getParameter(key) == null ? "" : request.getParameter(key);
		}

		return result;
	}

	public static String encode64(byte[] source)
	{
		return new String(Base64.encode(source));
	}

	public static byte[] decode64(String encodedtext) throws Exception
	{
		return Base64.decode(encodedtext);
	}
	
	
	// 사용자 PW 유효성검사 
	// 8자리 이상 , 영문 대문자/소문자/특수문자 최소 1개 이상 포함
	public static boolean isPWvalidation(String pw) {
		
		
		String pattern="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
		
		boolean regex = Pattern.matches(pattern, pw);
		
		return regex;
	}

	
	
	
}