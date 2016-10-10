package com.cecep.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Pattern;

public class CommonsUtil {
	
	/**
	 * 以separate为分隔符，返回String类型，数组中的对象需要实现toString方法
	 * 
	 * @param array
	 *            数组对象
	 * @param separate
	 * @return
	 */
	public static String join(Object[] array, String separate) {
		if (array != null && array.length > 0) {
			if (separate == null) {
				separate = ",";
			}
			if (array.length == 1) {
				return array[0].toString();
			} else {
				StringBuilder result = new StringBuilder();
				for (Object o : array) {
					result.append(o.toString() + separate);
				}
				return result.substring(0, result.length() - 1);
			}
		}
		return null;
	}

	public static String getCss(Object o) {
		return "<div style='color:red;font-size:14px'>" + o + "</div>";
	}

	public static String getLocalIp() {
		Enumeration<NetworkInterface> allNetInterfaces;
		InetAddress ip = null;
		String result = "";
		try {
			allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces
						.nextElement();
				Enumeration<InetAddress> addresses = netInterface
						.getInetAddresses();
				while (addresses.hasMoreElements()) {
					ip = (InetAddress) addresses.nextElement();
					if (ip != null && ip instanceof Inet4Address) {
						result = ip.getHostAddress();
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean match(String reg, String line){
		return Pattern.matches(reg, line);
	}
	
	public static void main(String[] args) {
		System.out.println(match("^\\d+[a-zA-Z]+", "235253asdsafasfas"));
		System.out.println(match("^\\d+[a-zA-Z]+", "a235253asdsafasfas"));
		System.out.println(match("^\\d+[a-zA-Z]+", "235253234"));
	}
}
