package com.jeizas.utils;

import java.util.regex.Pattern;

public class StringUtil {
	/**
	 * 判断字符串是否为null 或者为长度0
	 * @return true 不为null 长度也不为0
	 * 			false null 或者 长度为0
	 */
	public static boolean isValid(String str){
		return !(str == null || str.trim().length()==0);
	}
	
	public static boolean isInvalid(String str){
		return !isValid(str);
	}
	
	/**
	 * 判断一组字符串是否为null 或者为长度0
	 * @return true 所有字符串 均不为null 长度也不为0
	 * 			false 至少有一个为null 或者 长度为0
	 */
	public static boolean isAllValid(String ...strs){
		for(String str : strs){
			if(str == null || str.trim().length() == 0){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断字符串是否为纯数字
	 * @param str
	 * @return
	 */
	public static boolean isNumbers(String str){
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
	
	/**
	 * 判断字符串是否为N为的数字
	 * @param str
	 * @param length
	 * @return
	 */
	public static boolean isNDigits(String str, int length){
		Pattern pattern = Pattern.compile("[0-9]{"+ length+"}" );
		return pattern.matcher(str).matches();
	}
}
