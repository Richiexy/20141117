package com.xy.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;


public class StringUtil {

	private static String replace(String value) {
		return value.matches("^\'(.*)\'$") ? value : "'" + value + "'";
	}

	public static String change(String value) {
		StringBuffer sb = new StringBuffer();
		if (-1 != value.indexOf(',')) {
			String[] temp = value.split(",");
			for (int i = 0; i < temp.length; i++) {
				sb.append(replace(temp[i]));
				sb.append(',');
			}
			sb.deleteCharAt(sb.length() - 1);
		} else {
			sb.append(replace(value));
		}
		return sb.toString();
	}

	public static String spFormat(String value) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < value.length(); i++) {
			sb.append('[');
			sb.append(Integer.toHexString(value.codePointAt(i)));
			sb.append(']');
		}
		return sb.toString();
	}

	public static String dateFormat(String yyyyMMdd) {
		StringBuffer sb = new StringBuffer();
		sb.append(yyyyMMdd.substring(0, 4));
		sb.append("-");
		sb.append(yyyyMMdd.substring(4, 6));
		sb.append("-");
		sb.append(yyyyMMdd.substring(6, 8));
		return sb.toString();
	}

	public static String dateShowFormat(String yyyyMMdd) {
		StringBuffer sb = new StringBuffer();
		sb.append(yyyyMMdd.substring(0, 4));
		sb.append("年");
		sb.append(yyyyMMdd.substring(4, 6));
		sb.append("月");
		sb.append(yyyyMMdd.substring(6, 8));
		sb.append("日");
		return sb.toString();
	}

	public static String dateUnFormat(String yyyy_MM_dd) {
		StringBuffer sb = new StringBuffer();
		sb.append(yyyy_MM_dd.substring(0, 4));
		sb.append(yyyy_MM_dd.substring(5, 7));
		sb.append(yyyy_MM_dd.substring(8, 10));
		return sb.toString();// 测试

	}
	
	public static String numberToLarge(Integer num){
		String temp="";
		if(num==1){
			temp="一";
		}
		else if(num==2){
			temp="二";
		}
		else if(num==3){
			temp="三";
		}
		else if(num==4){
			temp="四";
		}
		else if(num==5){
			temp="五";
		}
		else if(num==6){
			temp="六";
		}
		else if(num==7){
			temp="七";
		}
		else if(num==8){
			temp="八";
		}
		else if(num==9){
			temp="九";
		}
		else if(num==10){
			temp="十";
		}
		else if(num==11){
			temp="十一";
		}
		else if(num==12){
			temp="十二";
		}
		else if(num==13){
			temp="十三";
		}
		else if(num==14){
			temp="十四";
		}
		else if(num==15){
			temp="十五";
		}
		else if(num==16){
			temp="十六";
		}
		else if(num==17){
			temp="十七";
		}
		else if(num==18){
			temp="十八";
		}
		return  temp;
	}

	public static String findANDReplace(String sql, String newStr) {
		String temp = "";
		if (sql.indexOf("ISWRITE=0") != -1) {
			temp = sql.replace("ISWRITE=0", newStr);
			return temp;
		} else if (sql.indexOf("ISWRITE=1") != -1) {
			temp = sql.replace("ISWRITE=1", newStr);
			return temp;
		} else if (sql.indexOf("1=1") != -1) {
			temp = sql.replace("1=1", newStr);
			return temp;
		}
		return null;

	}

	/**
	 * 时间格式转化 20100315--->2010-03-15
	 * 
	 * @param time
	 * @return
	 */
	public static String formatTime(String time) {

		String strTime = time.substring(0, 4);
		strTime += "-";
		strTime += time.substring(4, 6);
		strTime += "-";
		strTime += time.substring(6, 8);
		return strTime;
	}

	/**
	 * 分解字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String splitString(String str) {

		if (null == str || "".equals(str) || str.indexOf("_") == -1) {
			return str;
		} else {
			String[] splitStr = str.split("_");
			return splitStr[0];
		}

	}

	/**
	 * null 转换
	 * 
	 * @param num
	 * @return
	 */
	public static Integer nullToInteger(Integer num) {

		if (null != num) {
			return num;
		} else {
			return 0;
		}

	}

	public static Integer nullToInteger(String num) {

		if (null == num || "".equals(num) || "-1".equals(num)) {
			return 0;
		} else {
			return Integer.parseInt(num);
		}
	}

	public static Double nullToDouble(String num) {

		if (null == num || "".equals(num) || "-1".equals(num)) {
			return 0.00;
		} else {
			return Double.valueOf(num);
		}
	}

	public static Double nullToDouble(Double num) {

		if (null != num) {
			return num;
		} else {
			return 0.00;
		}
	}

	public static double nullToDouble(Integer num) {

		if (null != num) {
			return num;
		} else {
			return 0.00;
		}

	}

	public static String formatNumber(Integer num1, Integer num2) {

		String reStr = "";
		DecimalFormat myFormatter = new DecimalFormat("#.##");
		if (0 != nullToInteger(num2)) {
			double values = nullToDouble(num1) / nullToDouble(num2);
			reStr = myFormatter.format(values * 100);
		} else {
			reStr = "100";
		}
		return reStr;
	}

	public static String getFormatDate(String date) {

		NumberFormat n = NumberFormat.getNumberInstance();
		String reStr = "";
		if (null == date) {
			return "0.00";
		} else {
			double v = Double.parseDouble(date);
			n.setMinimumFractionDigits(2);
			reStr = n.format(v);
		}
		return reStr;
	}

	/**
	 * 数据格式化
	 * 
	 * @param num
	 * @return
	 */
	public static double formatNum(double... nums) {

		DecimalFormat myFormatter = new DecimalFormat("#.##");
		double d = 0.00;
		for (double num : nums) {
			d += num;
		}
		String reNum = myFormatter.format(d);
		return Double.valueOf(reNum);
	}

	/**
	 * 数据格式化
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String formatNumber(Double num1, Double num2) {

		String reStr = "";
		DecimalFormat myFormatter = new DecimalFormat("#.##");
		if (0 != nullToDouble(num2)) {
			double values = nullToDouble(num1) / nullToDouble(num2);
			reStr = myFormatter.format(values * 100);
		} else {
			reStr = "100";
		}
		return reStr;
	}

	/**
	 * null转换成空格
	 * 
	 * @param str
	 * @return
	 */
	public static String toNullTransString(String str) {

		if (null == str) {
			return "";
		}
		return str;
	}

	/**
	 * 两个时间进行比较，返回时间大的
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */

	public static String timeCompare(String time1, String time2) {

		SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat smt = new SimpleDateFormat("yyyyMMdd");
		String performTime = sFormat.format(new Timestamp(System
				.currentTimeMillis()));

		if (null == time1 || "".equals(time1)) {
			time1 = performTime;
		}

		if (null == time2 || "".equals(time2)) {
			time2 = performTime;
		}

		try {
			if (smt.parse(time1).after(smt.parse(time2))) {
				return time2;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time1;
	}

	public static synchronized String outputToJSArray(String[] strs) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			sb.append("'" + strs[i] + "',");
		}
		if (sb.length() != 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	public static synchronized String outputToJSArrayb(String[] strs) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			sb.append("\"" + strs[i] + "\",");
		}
		return sb.deleteCharAt(sb.length() - 1).toString();
	}

	/**
	 * 审计索引号编写规则: 业务属性拼音缩写+发现违规事实的年份（初次设置均为2010）+操作属性+违规类型（两层）+违规事实顺序号
	 * 本方法不包括违规事实顺序号
	 * 
	 * @param recordType
	 *            业务属性拼音缩写
	 * @param operateProperty
	 *            操作属性
	 * @param disciplineType
	 *            违规类型
	 * @return
	 */
	public static String getRecordId(String recordType, String operateProperty,
			String disciplineType) {
		StringBuffer recordId = new StringBuffer();
		recordId.append(recordType);
		recordId.append(DateUtil.convertDatetoMyString("yyyy", new Date()));
		recordId.append(operateProperty);
		recordId.append(disciplineType);
		recordId.append("00");
		return recordId.toString();
	}

	/**
	 * 数组的方式添加在store中
	 * 
	 * @param list
	 *            要显示字段值
	 * @return
	 */
	public static String getArrayDate(List<String[]> showList) {
		StringBuffer arrayString = new StringBuffer();
		arrayString.append("[");
		for (String str[] : showList) {
			arrayString.append("[");
			for (String field : str) {
				arrayString.append("'");
				if (null != field) {
					String temp = field;
					temp = temp.replaceAll("\'", "");
					temp = temp.replaceAll("\n", "");
					temp = temp.replaceAll("\r", "");
					temp = temp.replaceAll("\r\n'", "");
					arrayString.append(temp);
				} else {
					arrayString.append(field);
				}
				arrayString.append("',");
			}
			arrayString.deleteCharAt(arrayString.length() - 1);
			arrayString.append("],");

		}
		if (showList.size() > 0) {
			arrayString.deleteCharAt(arrayString.length() - 1);
		}
		arrayString.append("]");
		return arrayString.toString();
	}

	/**
	 * 数组的方式添加在store中
	 * 
	 * @param list
	 *            要显示字段值
	 * @return
	 */
	public static String getArrayData(String[] array) {
		StringBuffer arrayString = new StringBuffer();
		arrayString.append("[");
		for (String field : array) {
			arrayString.append("");
			if (null != field) {
				String temp = field;
				temp = temp.replaceAll("\'", "");
				temp = temp.replaceAll("\n", "");
				temp = temp.replaceAll("\r", "");
				temp = temp.replaceAll("\r\n'", "");
				arrayString.append(temp);
			} else {
				arrayString.append(field);
			}
			arrayString.append(",");
		}
		arrayString.deleteCharAt(arrayString.length() - 1);
		arrayString.append("]");

		return arrayString.toString();
	}

	/**
	 * 用json对象的方式，展现数据
	 * 
	 * @param showList
	 * @param totalRecords
	 * @param feilds
	 *            要显示的字段
	 * @param cnFeilds
	 *            显示的中文名
	 * @return
	 */
	public static String getDynamiColumnJson(List<String[]> showList,
			String[] feilds, String[] cnFeilds, int totalRecords) {
		StringBuffer jsonString = new StringBuffer();
		jsonString.append(getJsonDate(showList, feilds, totalRecords));
		jsonString = jsonString.deleteCharAt(jsonString.length() - 1);

		jsonString.append(",'columModle':[");
		int i = 0;
		for (String c : cnFeilds) {
			jsonString.append("{'header': '" + c + "','dataIndex': '"
					+ feilds[i] + "'}, ");
			i++;
		}
		if (cnFeilds.length > 0) {
			jsonString.deleteCharAt(jsonString.length() - 1);
		}
		jsonString.append("]");

		jsonString.append(",'fieldsNames':[");
		int j = 0;
		for (String f : feilds) {
			jsonString.append("{name: '" + f + "'},");
			j++;
		}
		if (feilds.length > 0) {
			jsonString.deleteCharAt(jsonString.length() - 1);
		}
		jsonString.append("]");
		jsonString.append("}");

		return jsonString.toString();

	}

	/**
	 * 用json对象的方式，展现数据
	 * 
	 * @param showList
	 * @param totalRecords
	 * @param feilds
	 *            要显示的字段
	 * @return
	 */
	public static String getJsonDate(List<String[]> showList, String[] feilds,
			int totalRecords) {

		StringBuffer jsonString = new StringBuffer();
		jsonString.append("{");
		jsonString.append("totalRecords:" + totalRecords + ",");
		jsonString.append("'results':[");
		for (String[] str : showList) {
			int i = 0;
			jsonString.append("{");
			for (String string : str) {
				jsonString.append(feilds[i].trim() + ":'");
				String s = "";
				if (null == string || "".equals(string.trim())
						|| "null".equalsIgnoreCase(string.trim())) {
					jsonString.append(s + "',");
				} else {
					jsonString.append(string.trim() + "',");
				}

				i++;
			}
			jsonString.deleteCharAt(jsonString.length() - 1);
			jsonString.append("},");
		}
		if (showList.size() > 0) {
			jsonString.deleteCharAt(jsonString.length() - 1);
		}
		jsonString.append("]}");
		return jsonString.toString();
	}

	/**
	 * 用模型数据 json对象的方式，展现数据
	 * 
	 * @param showList
	 * @param totalRecords
	 * @param feilds
	 *            要显示的字段
	 * @return
	 */
	public static String getModelJsonDate(List<String[]> showList,
			String[] feilds, int totalRecords) {
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("{");
		jsonString.append("totalRecords:" + totalRecords + ",");
		jsonString.append("'results':[");
		int j = 0;
		for (String[] str : showList) {
			int i = 0;
			jsonString.append("{");

			for (int k = 0; k < str.length; k++) {
				String string = str[k];
				jsonString.append(feilds[i].trim() + ":'");
				String s = "";
				if (null == string.trim() || "".equals(string.trim())
						|| "null".equalsIgnoreCase(string.trim())) {
					jsonString.append(s + "',");
					// }else if("查看".equals(feilds[i].trim())){
					// jsonString.append("影像',");
					// k=-1;
				} else {
//					if ((feilds[i].indexOf("金额")) != -1
//							|| (feilds[i].indexOf("余额")) != -1) {
//						jsonString.append("￥" + string + "',");
//					} else {
						jsonString.append(string + "',");
//					}
				}
				i++;
			}
			jsonString.append("num:'" + j + "'");
			jsonString.append("},");
			j++;
		}
		if (showList.size() > 0) {
			jsonString.deleteCharAt(jsonString.length() - 1);
		}
		jsonString.append("]}");
		return jsonString.toString();
	}

	public static List<String[]> getResult(List<String[]> resultList,
			List<Integer> cs, List<String> img) {

		List<String[]> list = new ArrayList<String[]>();
		for (String[] row : resultList) {
			StringBuffer para = new StringBuffer();
			StringBuffer para2 = new StringBuffer();
			String[] ro = (String[]) row;
			for (int i = 0; i < cs.size(); i++) {
				para.append(img.get(i) + "=" + ro[cs.get(i)].trim() + "&");
				para2.append(img.get(i) + "*" + ro[cs.get(i)].trim() + "$");
			}
			String paras = para.deleteCharAt(para.length() - 1).toString();
			String str[] = new String[ro.length + 1];
			str[0] = paras.trim();
			for (int i = 1; i < str.length; i++) {
				str[i] = ro[i - 1].trim();
			}
			list.add(str);
		}

		return list;
	}

	public static List<String[]> getResult(List<String[]> resultList,
			List<Integer> cs, List<String> img, int imgLocation) {

		List<String[]> list = new ArrayList<String[]>();
		for (String[] row : resultList) {
			StringBuffer para = new StringBuffer();
			StringBuffer para2 = new StringBuffer();
			String[] ro = (String[]) row;
			for (int i = 0; i < cs.size(); i++) {
				para.append(img.get(i) + "=" + ro[cs.get(i) + 1] + "&");
				para2.append(img.get(i) + "*" + ro[cs.get(i) + 1] + "$");
			}
			String paras = para.deleteCharAt(para.length() - 1).toString();
			String str[] = new String[ro.length + 1];

			for (int i = 0; i < ro.length + 1; i++) {
				if (i < imgLocation) {
					str[i] = ro[i].trim();
				} else if (i > imgLocation) {
					str[i] = ro[i - 1].trim();
				} else {
					str[imgLocation] = paras.trim();
				}
			}
			list.add(str);
		}

		return list;
	}

	/**
	 * 过滤字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String getStringFormat(String str) {
		String[] format = str.split("@");
		List<String> fieldList = new ArrayList<String>();// 字段名
		List<String> valueList = new ArrayList<String>();// 值
		int i = 0;
		for (String string : format) {
			if (i % 2 == 0) {
				fieldList.add(string);
			} else {
				valueList.add(string);
			}
			i++;
		}
		StringBuffer filters = new StringBuffer();
		int j = 0;
		for (String s : valueList) {
			filters.append(fieldList.get(j));
			filters.append(" like '%");
			filters.append(s + "%'");
			if (j < valueList.size() - 1) {
				filters.append(" and ");
			}
			j++;
		}
		return filters.toString();
	}

	/**
	 * 过滤字符串 IN操作 字符组合成IN操作，此方式适合过滤条件为List的情况
	 * 
	 * @param str
	 * @return
	 */
	public static String getStringFormatIn(String str, Map replaceStr,
			Map strType) {
		String[] format = str.split("@");
		List<String> fieldList = new ArrayList<String>();// 字段名
		List<String> valueList = new ArrayList<String>();// 值
		int i = 0;
		for (String string : format) {
			if (i % 2 == 0) {
				fieldList.add(string);
			} else {
				valueList.add(string);
			}
			i++;
		}
		StringBuffer filters = new StringBuffer();
		int j = 0;

		for (String s : valueList) {
			String fieldName = fieldList.get(j);
			if (j > 0) {
				filters.append(" and ");
			}
			filters.append(fieldName);
			filters.append(" in(");
			String[] sArray = s.split(",");
			int x = 0;
			for (String sy : sArray) {
				if (replaceStr.size() > 0) {
					if (!"int".equals(strType.get(fieldName))) {// 字符类型
						filters.append("'");
					}
					filters.append(replaceStr.get(sy));
					if (!"int".equals(strType.get(fieldName))) {
						filters.append("'");
					}
				} else {
					if (!"int".equals(strType.get(fieldName))) {
						filters.append("'");
					}
					filters.append("'" + sy + "'");
					if (!"int".equals(strType.get(fieldName))) {
						filters.append("'");
					}
				}
				x++;
				if (x <= sArray.length - 1) {
					filters.append(",");
				}

			}
			filters.append(" )");
			j++;
		}
		return filters.toString();
	}

	/**
	 * 将过滤条件转化为哈希结构
	 * 
	 * @param filters 
	 * @return
	 */
	public static Map<String,String[]> getFiltersMap(String filters) {
		if(StringUtils.isEmpty(filters)) {
			return null;
		}
		Map<String,String[]> map = new HashMap<String,String[]>();
		int index = 0;
		String key = null;
		String[] values = null;
		String[] filtersArr = filters.split("@");
		for(String filter:filtersArr) {
			if(index % 2 == 0) {
				key = filter;
			} else {
				values = filter.split(",");
				map.put(key, values);
			}
			index++;
		}
		return map;
	}

	

	public static String getDoubleString(String str) {
		String splitStr[] = str.split("E-");
		StringBuffer tempStr = new StringBuffer("0.");
		if (splitStr.length > 1) {
			String pointStr[] = splitStr[0].split("\\.");
			int num = Integer.parseInt(splitStr[1]);
			if (pointStr.length > 1) {
//				int tempInt = Integer.parseInt(pointStr[1]);
				for (int i = 0; i < num - 1; i++) {
					tempStr.append("0");
				}
				tempStr.append(pointStr[0]);
				tempStr.append(pointStr[1]);
			} else {
				for (int i = 0; i < num; i++) {
					tempStr.append("0");
				}
			}
			return tempStr.toString();
		} else {
			return str;
		}

	}

	/**
	 * 格式化字符串
	 * 
	 * @param colums
	 * @return
	 */
	public static String formatString(String colums) {
		String str = "";
		str = colums.replaceAll("\\[", "");
		str = str.replaceAll("\\]", "");
//		str = str.replaceAll("\\)", "");
//		str = str.replaceAll("\\(", "");
		str = str.replaceAll("（", "");
		str = str.replaceAll("）", "");
		str = str.replaceAll("/", "");
		str = str.replaceAll("\\\\", "");
		str = str.replaceAll("\\}", "");
		str = str.replaceAll("\\{", "");
		str = str.replaceAll("\'", "");
		str = str.replaceAll("\"", "");
		str = str.replaceAll(",", "");
		str = str.replaceAll("\r", "");
		str = str.replaceAll("\n", "");
		str = str.replaceAll("\r\n", "");
		return str;
	}

	/**
	 * 对小数进入格式化
	 * 
	 * @param colums
	 *            数据
	 * @return
	 */
	public static String formatNumber(String colums) {
		String str = "";
		str = colums.replaceAll("\\[", "");
		str = str.replaceAll("\\]", "");
		str = str.replaceAll("\\)", "");
		str = str.replaceAll("\\(", "");
//		str = str.replaceAll("（", "");
//		str = str.replaceAll("）", "");
		str = str.replaceAll("/", "");
		str = str.replaceAll("\\\\", "");
		str = str.replaceAll("\\}", "");
		str = str.replaceAll("\\{", "");
		str = str.replaceAll("\'", "");
		str = str.replaceAll("\"", "");
		str = str.replaceAll(",", "");
		str = str.replaceAll("\r", "");
		str = str.replaceAll("\n", "");
		str = str.replaceAll("\r\n", "");
		str = StringUtil.getDoubleString(str);
		return str;
	}

	/**
	 * 判断整型
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isIntger(String str) {
		return str.matches("[\\d]+");
	}

	/**
	 * 判断小数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		return str.matches("[\\d.]+");
	}

	public static String getColNames(String colums) {
		String str = "";
		str = colums.replaceAll("\\[", "");
		str = str.replaceAll("\\]", "");
		str = str.replaceAll("\\)", "");
		str = str.replaceAll("\\(", "");
//		str = str.replaceAll("（", "");
//		str = str.replaceAll("）", "");
		str = str.replaceAll("/", "");
		str = str.replaceAll("\\\\", "");
		str = str.replaceAll("\\}", "");
		str = str.replaceAll("\\{", "");
		str = str.replaceAll("\'", "");
		str = str.replaceAll("\"", "");
		str = str.replaceAll("\r", "");
		str = str.replaceAll("\n", "");
		str = str.replaceAll("\r\n", "");
		str = str.replaceAll(":", "");
		str = Pattern.compile("[\\s\\p{Zs}]").matcher(str).replaceAll("");
		return str;
	}
	
	/**
	 * 去掉\r , \n
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceString(String str) {
		str = str.replaceAll("\"", "");
		str = str.replaceAll("\r", "");
		str = str.replaceAll("\n", "");
		str = str.replaceAll("\r\n", "");
		//str = Pattern.compile("[\\s\\p{Zs}]").matcher(str).replaceAll("");
		return str;
	}

	public static List<String[]> getFiterDate(List<String[]> resultList) {
		List<String[]> resultList1 = new ArrayList<String[]>();
		for (String[] ss : resultList) {
			int i = 0;
			String f[] = new String[ss.length];
			for (String s : ss) {
				f[i++] = StringUtil.formatString(s);
			}
			resultList1.add(f);
		}
		return resultList1;
	}

	/**
	 * 过滤加工数据
	 * 
	 * @param resultList
	 *            数据
	 * @param fieldType
	 *            数据类型
	 * @return
	 */
	public static List<String[]> getFiterDate(List<String[]> resultList,
			List<String> fieldList) {
		String TypeString = "DECIMAL,DEC,NUMERIC,NUM,DOUBLE,DOUBLE PRECISION,FLOAT";

		List<String[]> resultList1 = new ArrayList<String[]>();
		for (String[] ss : resultList) {
			int i = 0;
			String f[] = new String[ss.length];
			for (String s : ss) {
				if (TypeString.indexOf(fieldList.get(i).toUpperCase()) != -1) {
					f[i++] = StringUtil.formatNumber(s);
				} else {
					f[i++] = StringUtil.formatString(s);
				}
			}
			resultList1.add(f);
		}
		return resultList1;
	}

	/**
	 * 过滤加工数据
	 * 
	 * @param String
	 *            数据
	 * @return
	 */
	public static boolean isNumberType(String type) {
		String TypeString = "DECIMAL,DEC,NUMERIC,NUM,DOUBLE,DOUBLE PRECISION,FLOAT";
		if (TypeString.indexOf(type.toUpperCase()) != -1) {
			return true;
		} else {
			return false;
		}
	}

	

	/**
	 * 输出到页面
	 * 
	 * @param response
	 * @param str
	 * @return
	 */
	public static void println(HttpServletResponse response, String str) {
		response.setContentType("text/json; charset=utf-8");
		try {
			response.getWriter().print(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 对文件特殊字符处理
	 * 
	 * @param str
	 * @return
	 */
	public static boolean fileSecialCharacter(String str) {
		String single[] = str.split("\'");
		String andMark[] = str.split("&");
		if (single.length < 2 && andMark.length < 2) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 得到传入String参数的字节长度(中文两个字节)
	 * 如果参数为空将抛出IllegalArgumentException异常
	 * 
	 * @param arg String字符串
	 * @return int
	 */
	public static int getBytesLength(String arg){
		if(arg == null) {
			throw new IllegalArgumentException("参数不能为空.");
		}
		return arg.getBytes().length;
	}
	
	
	/**
	 * 参数存放条件列表，返回查询条件
	 * 
	 * @param list 存放字符串条件 格式(如：字段名=值)
	 * @return String
	 */
	public static String getConditionFromList(List<String> list) {
		if(list == null) return "";
		StringBuffer conditionBuffer = new StringBuffer();
		for(String condition:list){
			if(conditionBuffer.length() == 0) {
				conditionBuffer.append(" ").append(condition).append(" ");
			} else {
				conditionBuffer.append(" and ").append(condition).append(" ");
			}
		}
		return conditionBuffer.toString();
	}

	/**
	 * 判断是否为null或者空字符串，是返回false 
	 * @param s 要判断的字符串
	 * @return 
	 */
	public static boolean isNotNull(String s){
		if(s==null || "".equals(s.trim()) || "null".equalsIgnoreCase(s))
			return false;
		else
			return true;
	}
	/**
	 * 
	 */
	public static String getNumberByString(String str){
		Object in = null;
		String ing = null;
		for (int i = 0; i < str.length(); i++) {
			in = str.charAt(i);
			if (in.toString().matches("[0-9]{1,}") == true) {
				if (ing != null) {
					ing = ing.concat(in.toString());
				} else {
					ing = in.toString();
				}
			}
		}
//		System.out.println(ing);
		return ing;
	}
	
	/**
	 * 把ascii码转换成对应字符串
	 * @param str 要转换的ascii码
	 * @param sp ascii码直接连接的字符
	 * @return
	 */
	public static String getStringByAscii(String str,String sp){
		String[] proNames=str.split(sp);
		StringBuffer sb=new StringBuffer();
		for (String pName : proNames) {
			char c = (char)Integer.parseInt(pName.trim());
			sb.append(c);
		}
		return sb.toString();
	}
	
	/**
	 * 把字符串转化成ascii码
	 * @param value 字符串
	 * @return
	 */
	public static String stringToAscii(String value){
	  StringBuffer sbu = new StringBuffer();
	  char[] chars = value.toCharArray();
	  for (int i=0; i < chars.length; i++) {
		  if(i!= chars.length - 1){
			  sbu.append((int)chars[i]).append(",");
		   }else {
			   sbu.append((int)chars[i]);
		   }
	  }
	  return sbu.toString();
	 }

	
	/**
	 * 去掉左边空格
	 * 
	 * @param arg
	 * @return
	 */
	public static String ltrim(String arg) {
		if(StringUtils.isEmpty(arg)) return "";
		while(arg.indexOf(" ") == 0 && arg.length() > 1) {
			arg = arg.substring(1, arg.length());
		}
		return arg;
	}
	
	/**
	 * 去掉右边空格
	 * 
	 * @param arg
	 * @return
	 */
	public static String rtrim(String arg) {
		if(StringUtils.isEmpty(arg)) return "";
		while(arg.lastIndexOf(" ") == arg.length()-1 && arg.length() > 1) {
			arg = arg.substring(0, arg.length()-1);
		}
		return arg;
	}
	
	/**
	 * 去掉左边和右边空格
	 * 
	 * @param arg
	 * @return
	 */
	public static String lrtrim(String arg) {
		return ltrim(rtrim(arg));
	}
	
	public static String arrayToString(String[] array) {
		String value = "";
		if(array == null) return "";
		for(int i = 0; i < array.length; i++) {
			value += value.length() == 0 ? array[i] : ","+array[i];
		}
		return value;
	}
	
	public static String replaceAllSpace(String arg) {
		if(StringUtils.isEmpty(arg)) return arg;
		return Pattern.compile("[\\s\\p{Zs}]").matcher(arg).replaceAll("");
	}
	
	/**
	 * 数字格式转化
	 * @param num 小数点位数
	 * @param data 数据
	 * @return
	 */
	public static String dataReverse(int num,String data){
		StringBuffer format=new StringBuffer("0.");
		for(int i=0;i<num;i++){
			format.append("0");
		}
		if(null==data||"".equals(data)||"null".equalsIgnoreCase(data)){
			data="0.00";
		}
	    DecimalFormat myFormatter = new DecimalFormat(format.toString()); 
	    double values = Double.parseDouble(data); 
	    return myFormatter.format(values);
	}
	
	/**
	 * 四舍五入求值
	 * 
	 * @param v     原始数值
	 * @param scale 小数点位数
	 * @return 如果scale参数小于0则返回v
	 */
	public static double round(double v,int scale) {
		if(scale<0){
			return v;
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal oneValue = new BigDecimal("1");
		return b.divide(oneValue,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static String formate(double v,String formater) {
		DecimalFormat d = new DecimalFormat(formater);
		return d.format(v);
	}
	
	/**
	 * Long型转换为Integer
	 * @param v
	 * @return
	 */
	public static Integer longToInt(Long v) {
		if(v == null) 
			return 0;
		return Integer.parseInt(v+"");	
	}
	
	/**
	 * 获取一个n位的随机数
	 * @return
	 */
	public static String getRandom(int num) {
		double v = Math.random();
		Long l = 1L;
		for(int i = 0; i < num; i++) {
			l = l*10;
		}
		StringBuffer f = new StringBuffer();
		while(f.length() < num) f.append("0");
		return formate(v*l,f.toString());
	}
	
	/**
	 * 
	* @Description: 获得定长的字符，不足长度前面补0
	* creator：yuxf   
	* createTime：2012-7-31 下午02:43:08   
	* @param @param str
	* @param @param length
	* @param @return
	* @param @throws CmsRunTimeException    
	* @return String    
	* @throws
	 */
	public static String getFixedLenLeftStr(String str,int length) throws RuntimeException{
		if(null != str && (length <=0 || str.length()>length)){
			throw new RuntimeException("输入的字符不符合");
		}else{
			while(null==str || str.length()<length){
				str = "0"+(null==str?"1":str);
			}
		}
		return str;
	}
	
}








