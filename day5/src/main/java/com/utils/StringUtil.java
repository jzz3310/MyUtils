package com.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class StringUtil {
	
	//判断该字符串中是否是一个小数
	public static Boolean isFloat(String str){
		try {
			if(str.split("\\.")[0].equals("0") || str.split("\\.").length==2 && !str.startsWith("0")){
				Integer.parseInt(str.replace(".", "0"));
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return false;
	}
	
	//判断该字符串是否为空，空字符串也是空，空格也是空
	public static Boolean isEmpty(String str){
		if(str == null || str.trim().length() == 0){
			return true;
		}
		return false;
	}
	
	//判断该字符串是否是一个手机号
	public static Boolean isPhone(String str){
		String reg = "1[3|5|6|7|8]\\d{9}";
		return str.matches(reg);
	}
	
	//判断该字符串是否为电子邮箱
	public static Boolean isEmail(String str){
		String reg = "\\w+@\\w+[.com|.cn|.net]";
		return str.matches(reg);
	}
	
	//判断该字符串是否全部为字母
	public static Boolean isLetter(String str){
		String reg = "[A-Za-z]+";
		if(str.isEmpty()){
			return false;
		}else {
			return str.matches(reg);
		}
	}
	
	//获取n位随机英文字符串
	public static String getRandomLetter(int num){
		StringBuffer br = new StringBuffer();
		Random rm = new Random();
		for(int i = 0; i < num; i ++){
			String ascill = (char)rm.nextInt(123)+"";
			if(isLetter(ascill)){
				br.append(ascill);
			}else{
				i--;
			}
		}
		return br.toString();
	}
	
	//获取n位随机的字符串，其中只能包含字母和数字
	public static String getRandomLetterAndNum(int num){
		StringBuffer br = new StringBuffer();
		Random rm = new Random();
		for(int i = 0; i < num; i ++){
			String ascill = (char)rm.nextInt(123)+"";
			if(isLetter(ascill) || isNumber(ascill)){
				br.append(ascill);
			}else{
				i--;
			}
		}
		return br.toString();
	}
	
	//判断该字符串是否是一个整数
	public static Boolean isNumber(String str){
		String reg = "\\d+";
		if(str.isEmpty()){
			return false;
		}else {
			return str.matches(reg);
		}
	}
	
	//获取n个随机的中文字符串
	public static String getChinese(int length){
		StringBuilder br = new StringBuilder();
		int hs = 0;
		int ls = 0;
		Random rm = new Random();
		for(int i = 0; i < length; i ++){
			hs = (176 + Math.abs(rm.nextInt(39)));
			hs = (161 + Math.abs(rm.nextInt(93)));
			byte[] b = new byte[2];
			b[0] = new Integer(hs).byteValue();
			b[1] = new Integer(ls).byteValue();
			try {
				br.append(new String(b,"GBK"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		return br.toString();
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(getChinese(5));
	}
}
