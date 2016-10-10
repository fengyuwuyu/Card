package com.cecep.util;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.cecep.model.kq.KqRecord;

public class KqStatisticsUtil {

	private static List<String> days = new CopyOnWriteArrayList<String>();
	private static java.sql.Date kssj = null;
	private static java.sql.Date jssj = null;
	private static Random random = new Random();
	/** yyyy-MM-dd*/
	private static SimpleDateFormat dateFormat1 = new SimpleDateFormat(
			"yyyy-MM-dd");
	/** yyyy-MM-dd HH:mm:ss*/
	private static SimpleDateFormat dateFormat2 = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	/** HH:mm:ss*/
	private static SimpleDateFormat dateFormat3 = new SimpleDateFormat(
			"HH:mm:ss");
	private static SimpleDateFormat dateFormat4 = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	
//	public static void main(String[] args) {
//		try {
//			Date date = dateFormat2.parse("2016-02-03 9:12:00");
//			Time time = Time.valueOf("9:18:00");
//			compareTime(date, time);
//			compareTime1(date, time);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	/**
	 * 获取一段时间内的每一天的日期集合
	 * 
	 * @param kssj
	 * @param jssj
	 * @return
	 */
	public static List<String> getDays(java.sql.Date kssj, java.sql.Date jssj) {
		if (kssj == KqStatisticsUtil.kssj && jssj == KqStatisticsUtil.jssj) {
			if (KqStatisticsUtil.days.size() > 0) {
				return KqStatisticsUtil.days;
			}
		}
		KqStatisticsUtil.days.clear();
		KqStatisticsUtil.kssj = kssj;
		KqStatisticsUtil.jssj = jssj;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dBegin = new java.util.Date(kssj.getTime());
		java.util.Date dEnd = new java.util.Date(jssj.getTime());
		KqStatisticsUtil.days.add(sdf.format(dBegin));
		Calendar calBegin = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(dEnd);
		// 测试此日期是否在指定日期之后
		while (dEnd.after(calBegin.getTime())) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			KqStatisticsUtil.days.add(sdf.format(calBegin.getTime()));
		}
		return KqStatisticsUtil.days;
	}

	public static List<String> getWorkday(List<String> days, List<String> holiday) {
		days.removeAll(holiday);
		return days;
	}

	/**
	 * 以yyyy-MM-dd格式格式化传入的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateToString1(Date date) {
		return dateFormat1.format(date);
	}

	/**
	 * 以MM-dd HH:mm格式格式化传入的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateToString2(Date date) {
		String result = dateFormat2.format(date);
		result = result.substring(5);
		result = result.substring(0, result.length()-3);
		return result;
	}
	
	/**
	 * 以yyyy-MM-dd HH:mm:ss格式格式化传入的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateToString3(Date date) {
		return dateFormat2.format(date);
	}
	
	/**
	 * 以yyyyMMddHHmmss格式格式化传入的时间，并加上一个随机的两位数
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateToString6(Date date) {
		return dateFormat4.format(date)+KqStatisticsUtil.getRandom();
	}
	
	/**
	 * 以MM-dd格式格式化传入的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateToString5(Date date) {
		return (formatDateToString2(date)).substring(0, 5);
	}
	
	/**
	 * 以HH:mm:ss格式格式化传入的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateToString4(Date date) {
		return dateFormat3.format(date);
	}
	
	/**
	 * 去掉字符串的最后一个字符
	 * @param string
	 * @return
	 */
	public static String subLastChar(StringBuilder string){
		if(string.length()>6){
			if(",<br".equals(string.substring(string.length()-5, string.length()-1))){
				return string.substring(0, string.length()-5);
			}
			return string.substring(0, string.length()-1);
		}
		return string.toString();
	}
	
	/**
	 * 判断考勤记录的时间是否小于规定的时间，小于则返回true，大于返回false
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static boolean compareTime(Date date, Time time) {
		int dateHour = date.getHours();
		int dateMinute = date.getMinutes();
		int timeHour = time.getHours();
		int timeMinute = time.getMinutes();
		if (dateHour < timeHour || (dateHour == timeHour && dateMinute <= timeMinute)) {
			return true;
		}
		return false;
	}
	
	public static boolean compareTime1(Date date, Time time) {
		String p_date = formatDateToString4(date);
		String p_time = formatDateToString4(time);
		Time date_time = Time.valueOf(p_date);
		Time time_time = Time.valueOf(p_time);
		if(date_time.before(time_time)){
			return true;
		}
		return false;
	}
	
	public static Map<String, List<KqRecord>> transListToTreeMap(List<KqRecord> kqRecords,List<String> workday){
		Map<String, List<KqRecord>> recordsByWorkday = new TreeMap<String, List<KqRecord>>();
		if (workday == null || kqRecords==null) {
			return null;
		}
		for (String s : workday) {
			recordsByWorkday.put(s, null);
		}
		for (KqRecord record : kqRecords) {
			Date sj = record.getSj();
			String formatDate = KqStatisticsUtil.formatDateToString1(sj);
			if (recordsByWorkday.get(formatDate) == null) {
				ArrayList<KqRecord> list = new ArrayList<KqRecord>();
				recordsByWorkday.put(formatDate, list);
			}
			recordsByWorkday.get(formatDate).add(record);
		}
		
		return recordsByWorkday;
	}
	
	public static int getRandom(int n){
		return random.nextInt(n);
	}
	
	public static int getRandom(){
		return random.nextInt(100);
	}
	
	/**
	 * 以yyyy-MM-dd格式返回当天日期
	 * @return
	 */
	public static String getCurrDay(){
		return formatDateToString1(new Date());
	}
}
