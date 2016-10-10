package com.cecep.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于创建业务需要的Map对象
 * 
 * @author lilei
 * 
 */
public class MapUtils {

	/**
	 * args的长度必须是偶数，args奇数位的类型必须是String类型
	 * 
	 * @param args
	 *            Object数组
	 * @return
	 */
	public static Map<String, Object> createMap(Object... args) {
		if (args.length % 2 != 0) {
			throw new IllegalArgumentException("传入的参数必须是偶数！");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < args.length; i += 2) {
			if (!(args[i] instanceof String)) {
				throw new IllegalArgumentException("参数的奇数对象类型必须是String！");
			}
			map.put((String) args[i], args[i + 1]);
		}
		return map;
	}

	/**
	 * args的长度必须是偶数
	 * 
	 * @param args
	 *            Object数组
	 * @return
	 */
	public static Map<Object, Object> createMap1(Object... args) {
		if (args.length % 2 != 0) {
			throw new IllegalArgumentException("传入的参数必须是偶数！");
		}
		Map<Object, Object> map = new HashMap<Object, Object>();
		for (int i = 0; i < args.length; i += 2) {
			map.put((String) args[i], args[i + 1]);
		}
		return map;
	}

	/**
	 * 创建一个请求成功的Map
	 * 
	 * @param message
	 * @return
	 */
	public static Map<String, Object> createSuccessMap(Object... args) {
		Map<String, Object> successMap = null;
		if (args != null&&args.length>0) {
			successMap = createMap(args);
			successMap.put("success", true);
		} else {
			successMap = createMap("success", true,"msg","操作成功！");
		}
		return successMap;
	}

	/**
	 * 创建一个请求失败的Map
	 * 
	 * @param message
	 * @return
	 */
	public static Map<String, Object> createFailedMap(Object... args) {
		Map<String, Object> failedMap = null;
		if (args != null&&args.length>0) {
			failedMap = createMap(args);
			failedMap.put("success", false);
		} else {
			failedMap = createMap("success", false,"msg","操作失败！");
		}
		return failedMap;
	}

	public static Map<String, Object> createEmptyDataListMap() {
		return createSuccessMap("rows", new ArrayList<Object>(), "total", 0);
	}

}
