package com.church.visit.utils;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class StrUtils {
	/**
	 * 禁止实例化
	 */
	private StrUtils() {
	}

	public static boolean isEmpty(String arg) {
		if (arg == null || "".equals(arg)) {
			return true;
		}
		return false;
	}
	
	public static boolean isEmptyList(List<String> args) {
		if (args == null || args.isEmpty()) {
			return true;
		}
		return false;
	}

	public static List<Long> splitToLong(String args) {

		List<String> idStrList = splitToString(args);
		List<Long> idList = Lists.newArrayList();

		for (String id : idStrList) {
			if (StrUtils.isNumber(id)) {
				idList.add(Long.valueOf(id));
			}
		}

		return idList;
	}

	public static List<String> splitToString(String args) {
		if (args == null) {
			return Lists.newArrayList();
		}
		Splitter spliter = Splitter.on(",").omitEmptyStrings().trimResults();
		List<String> labels = Lists.newArrayList(spliter.split(args));
		return labels;
	}
	public static boolean isNumber(String s) {
		if (isEmpty(s)) {
			return false;
		} else {
			for (int i = 0; i < s.length(); i++) {
				if (!((s.charAt(i) >= '0') && (s.charAt(i) <= '9'))) {
					return false;
				}
			}
			return true;
		}
	}
	
	
	/**
	 * 改写equals
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isEqual(String str1, String str2) {
		if(StringUtils.isEmpty(str1)) {
			if(StringUtils.isEmpty(str2)) {
				return true;
			}
			return false;
		} else {
			return str1.equals(str2);
		}
	}
	
	/**
	 * 解析url地址栏参数到map  (半路径)
	 * @param string  问号以后的字符串  如："a=1&b=2&c=3&d=4"
	 * @return
	 */
	public static Map<String, String> shortUrlParamsParseToMap(String url) {
		//如果URL是空字符串
		if ("".equals(url)) {
			return null;
		}
		
        String[] paramSplit = url.split("&");
        Map<String,String> paramMap = new HashMap<String,String>(paramSplit.length);
        String[] param;
        for (String qs : paramSplit) {
        	param = qs.split("=");
        	paramMap.put(param[0], param[1]);
        }
        return paramMap;
	}
}
