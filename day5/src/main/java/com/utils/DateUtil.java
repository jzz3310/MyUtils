package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class DateUtil{
	
	//将Date转换成Calendar类型，类型Date
	public static Calendar dateToCalendar(Date date){
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		return instance;
	}
	
	//将Date转换成Calendar类型，类型String
		public static Calendar dateToCalendar(String dates){
			Date date = stringToDate(dates);
			return dateToCalendar(date);
		}
	
	//将该字符串转化成日期
	public static Date stringToDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	//输入出生日期，类型为String，得到年龄
	public static int getAge(String date){
		Date d = stringToDate(date);
		return getAge(d);
	}
	
	//输入出生日期，类型为Date，得到年龄
	public static int getAge(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		
		int nowYear = c.get(Calendar.YEAR);
		int dateYear = c1.get(Calendar.YEAR);
		
		return nowYear-dateYear;
	}
	
	//计算输入日期距离今天有多少天，参数为String
	public static int getFutureDays(String future){
		Date date = stringToDate(future);
		return getFutureDays(date);
	}
	
	//计算输入日期距离今天有多少天，参数为Date
	public static int getFutureDays(Date future){
		Date now = new Date();
		long nowTime = now.getTime();
		long futureTime = future.getTime();
		long times = futureTime-nowTime;
		int days = (int)(times/1000/60/60/24);
		return days;
	}
	
	//判断给定的日期是否是今天，参数是Date
	@SuppressWarnings("deprecation")
	public static Boolean isToday(Date date){
		Date nowDate = new Date();
		if(getFutureDays(date) == 0){
			if(date.getDay() == nowDate.getDay()){
				return true;
			}
		}
		return false;
	}
	
	//判断给定的日期是否是今天，参数是String
	public static Boolean isToday(String date){
		Date d = stringToDate(date);
		return isToday(d);
	}
	
	//判断当前给定的日期是否在本周之内
	public static boolean isDayInWeek(String date) {
		
		Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		int year = instance.get(Calendar.YEAR);
		int month = instance.get(Calendar.MONTH);
		int dayOfWeek = instance.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		
		Date stringToDate = stringToDate(date);
		Calendar dateToCalendar = dateToCalendar(stringToDate);
		int year1 = dateToCalendar.get(Calendar.YEAR);
		int month1 = dateToCalendar.get(Calendar.MONTH);
		int dayOfWeek1 = dateToCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		
		if(year==year1&&month==month1&&dayOfWeek==dayOfWeek1) {
			return true;
		}
		return false;
	}
	
	//给定时间对象，初始化到该年初的1月1日0时0分0秒0毫秒
	public static void  setInitDate(String str) {
		Date stringToDate = stringToDate(str);
		Calendar dateToCalendar = dateToCalendar(stringToDate);
		dateToCalendar.set(Calendar.MONTH, 1);
		dateToCalendar.set(Calendar.DAY_OF_YEAR, 1);
		dateToCalendar.set(Calendar.HOUR, 0);
		dateToCalendar.set(Calendar.MINUTE, 0);
		dateToCalendar.set(Calendar.SECOND, 0);
		dateToCalendar.set(Calendar.MILLISECOND, 0);
		System.out.println(dateToCalendar.getTime());
	}
	
	
	
	
	
}
