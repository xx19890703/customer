package com.xx.publics.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间util
 * 
 * @author xx
 * 
 */
public class DateUtil {

	/**
	 * 返回去年年初，格式为xxxx-01-01
	 * 
	 * @return
	 */
	public static String getLastYearStart() {
		Calendar rightNow = Calendar.getInstance();
		int year = rightNow.get(Calendar.YEAR) - 1;
		String date = year + "-01-01";
		return date;
	}

	public static String getSystemTime() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}

	
	public static String getSystemDate() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
	/**
	 * 获取一串日期字符串
	 * 
	 * @return
	 */
	public static String getDateStr() {
		Calendar cal = Calendar.getInstance();
		String dateStr = "";
		int mon = cal.get(Calendar.MONTH) + 1;
		int dat = cal.get(Calendar.DATE);
		String monStr = mon + "";
		if (mon <= 9) {
			monStr = "0" + mon;
		}
		if (dat <= 9) {
		}
		dateStr = cal.get(Calendar.YEAR) + "" + monStr;
		return dateStr;
	}

	/**
	 * 返回去年年初，格式为xxxx-12-31
	 * 
	 * @return
	 */
	public static String getLastYearEnd() {
		Calendar rightNow = Calendar.getInstance();
		int year = rightNow.get(Calendar.YEAR) - 1;
		String date = year + "-12-31";
		return date;
	}

	/**
	 * 返回传入日期前一年年初，格式为xxxx-01-01
	 * 
	 * @return
	 */
	public static String getYearStartByTime(String time) {
		try {
			String years = time.substring(0, 4);
			int year = Integer.parseInt(years) - 1;
			String date = year + "-01-01";
			return date;
		} catch (Exception e) {
			return getLastYearStart();
		}
	}

	/**
	 * 返回传入日期前一年年末尾，格式为xxxx-12-31
	 * 
	 * @return
	 */
	public static String getYearEndByTime(String time) {
		try {
			String years = time.substring(0, 4);
			int year = Integer.parseInt(years) - 1;
			String date = year + "-12-31";
			return date;
		} catch (Exception e) {
			return getLastYearEnd();
		}
	}

	/**
	 * date转换String 格式：xxxx-xx-xx等
	 * 
	 * @param date
	 * @return
	 */
	public static String date2String(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static Date dateAdd(int days) {
		// 日期处理模块 (将日期加上某些天或减去天数)返回字符串
		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, days); // 日期减 如果不够减会将月变动
		return canlendar.getTime();
	}

	/**
	 * String转换 date 格式：xxxx-xx-xx等
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date string2Date(String date, String format)
			 {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 返回今年
	 * @return
	 */
	public static String getYear(){
		String s = getSystemDate();
		return s.split("-")[0];
	}
	
	/**
	 * 返回今天月份
	 * @return
	 */
	public static String getMonth(){
		String s = getSystemDate();
		return s.split("-")[1];
	}

	/**
	 * 返回今天日期
	 * @return
	 */
	public static String getDay(){
		String s = getSystemDate();
		return s.split("-")[2];
	}
	/**
	 * 返回今天星期几
	 * @return
	 */
	public static int getWeekDayString() {
		int weekString = 0;
		final int dayNames[] = { 7, 1, 2, 3, 4, 5,
				6 };
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		weekString = dayNames[dayOfWeek - 1];
		return weekString;
	}

	public static void main(String[] args) {
		System.out.print(getWeekDayString());
	}
}
