package com.xy.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang.time.FastDateFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.i18n.LocaleContextHolder;



/**
 * Date Utility Class
 * This is used to convert Strings to Dates and Timestamps
 * 
 * @version $Revision: 1.2 $ $Date: 2008/05/25 10:38:53 $
 */
public class DateUtil {
    //~ Static fields/initializers =============================================
	
    private static Log log = LogFactory.getLog(DateUtil.class);
    private static String defaultDatePattern = null;
    private static String timePattern = "HH:mm";
    private static final FastDateFormat yyyyMMdd=FastDateFormat.getInstance(Consts.yyyyMMdd);
	private static final FastDateFormat showDate=FastDateFormat.getInstance(Consts.showDate);

	
	//~ Methods ================================================================

    /**
     * Return default datePattern (MM/dd/yyyy)
     * @return a string representing the date pattern on the UI
     */
    public static synchronized String getDatePattern() {
        Locale locale = LocaleContextHolder.getLocale();
        try {
            defaultDatePattern = ResourceBundle.getBundle("ApplicationResources", locale)
                .getString("date.format");
        } catch (MissingResourceException mse) {
            defaultDatePattern = "MM/dd/yyyy";
        }
        
        return defaultDatePattern;
    }

    /**
     * This method attempts to convert an Oracle-formatted date
     * in the form dd-MMM-yyyy to mm/dd/yyyy.
     *
     * @param aDate date from database as a string
     * @return formatted string for the ui
     */
    public static final String getDate(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";
        if (aDate != null) {
            df = new SimpleDateFormat(getDatePattern());
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }
    
    /**
     * 获取当前日期
     * 
     * @param pattern 日期格式
     * @return
     */
    public static final String getCurrentDate(String pattern) {
    	SimpleDateFormat df=new SimpleDateFormat(pattern);
        return df.format(new Date());
    }

    /**
     * This method generates a string representation of a date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @see java.text.SimpleDateFormat
     * @throws ParseException
     */
    public static final Date convertStringToDate(String aMask, String strDate)
      throws ParseException {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);
        if (log.isDebugEnabled()) {
            log.debug("converting '" + strDate + "' to date with mask '"
                      + aMask + "'");
        }

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            //log.error("ParseException: " + pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }

    /**
     * This method returns the current date time in the format:
     * MM/dd/yyyy HH:MM a
     *
     * @param theTime the current time
     * @return the current date/time
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(timePattern, theTime);
    }

    /**
     * This method returns the current date in the format: MM/dd/yyyy
     * 
     * @return the current date
     * @throws ParseException
     */
    public static Calendar getToday() throws ParseException {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

        // This seems like quite a hack (date -> string -> date),
        // but it works ;-)
        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));

        return cal;
    }

    /**
     * This method generates a string representation of a date's date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param aDate a date object
     * @return a formatted string representation of the date
     * 
     * @see java.text.SimpleDateFormat
     */
    public static final String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            log.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * This method generates a string representation of a date based
     * on the System Property 'dateFormat'
     * in the format you specify on input
     * 
     * @param aDate A date to convert
     * @return a string representation of the date
     */
    public static final String convertDateToString(Date aDate) {
        return getDateTime(getDatePattern(), aDate);
    }
    /**
     * 分析字符串文本转化为Date
     * @param pattern
     * @param dateValue
     * @return Date
     */
    public static final Date convertMyStringtoDate(String pattern, String dateValue){
    	SimpleDateFormat df = new SimpleDateFormat(pattern);
    	Date date = new Date();
    	try{
    		date = df.parse(dateValue);
    	}catch(ParseException e){
    		e.printStackTrace();
    	}
    	return date;
    }
    /**
     * 将日期格式化输出
     * @param pattern
     * @param date
     * @return String
     */
    public static final String convertDatetoMyString(String pattern, Date date){
    	SimpleDateFormat df = new SimpleDateFormat(pattern);
    	return df.format(date);
    }
    /**
     * 将日期以一定的偏移量改变
     * @param date
     * @param value
     * @return Date
     */
    public static final Date dateChange(Date date, int value){
    	GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(GregorianCalendar.DAY_OF_MONTH, value);
		return cal.getTime();
    }
    /**
     * This method converts a String to a date using the datePattern
     * 
     * @param strDate the date to convert (in format MM/dd/yyyy)
     * @return a date object
     * 
     * @throws ParseException
     */
    public static Date convertStringToDate(String strDate)
      throws ParseException {
        Date aDate = null;

        try {
            if (log.isDebugEnabled()) {
                log.debug("converting date with pattern: " + getDatePattern());
            }

            aDate = convertStringToDate(getDatePattern(), strDate);
        } catch (ParseException pe) {
            log.error("Could not convert '" + strDate
                      + "' to a date, throwing exception");
            pe.printStackTrace();
            throw new ParseException(pe.getMessage(),
                                     pe.getErrorOffset());
                    
        }

        return aDate;
    }
    
    
    public static final synchronized String getyyyyMMdd(Date d){
    	return yyyyMMdd.format(d);
    }
    
    public static final synchronized String getShowDate(Date d){
    	return showDate.format(d);
    }
    
    /**
     * 时间格式的转换
     * @param time
     * @return
     */
    public static String transformTime(String time){
    	String year=time.substring(0, 4);
    	String month=time.substring(4, 6);
    	String day=time.substring(6, 8);
    	return year+"-"+month+"-"+day;
    }
    
	  public static List twoDays(String str1,String str2){
	        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	        List list = new ArrayList();
	       try {
	            Date b=df.parse(str1);
	            Date e=df.parse(str2);
	            Calendar c=Calendar.getInstance();
	            c.setTime(b);
	            while (e.compareTo(c.getTime())>=0){
	                  String tempDateStr = "";
	                  tempDateStr = new SimpleDateFormat("yyyyMMdd").format(c.getTime()).toString();
	                  list.add(tempDateStr);
	                  c.add(c.DATE, 1);
	            }
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }
	        return list;
	    }
	  
	  public static List<String> twoDaysNew(String str1,String str2){
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		  List<String> list = new ArrayList<String>();
		  try {
			  Date b=df.parse(str1);
			  Date e=df.parse(str2);
			  Calendar c=Calendar.getInstance();
			  c.setTime(b);
			  while (e.compareTo(c.getTime())>=0){
				  String tempDateStr = "";
				  tempDateStr = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()).toString();
				  list.add(tempDateStr);
				  c.add(c.DATE, 1);
			  }
		  } catch (Exception e1) {
			  e1.printStackTrace();
		  }
		  return list;
	  }

	  
	  /**
	   * 得到当前时间
	   * @param datePattern 时间格式
	   * @return  
	   */
	  public static String  getCurrentTime(String datePattern){
			SimpleDateFormat sdf = new SimpleDateFormat(datePattern);   
			long time = System.currentTimeMillis();  
			return sdf.format(new Date(time));
	  }
	  
	  /**
	   * 得时间段的月的个数
	   * @param str1
	   * @param str2
	   * @return
	   */
	  public static List<String> getTwoMonths(String begin, String end) {
		  List<String> list=new ArrayList<String>();
		try {
			  DateFormat df = new SimpleDateFormat("yyyy-MM");
			  Date beginDate = df.parse(begin);
			  Date endDate = df.parse(end);
			  
			  int beginYear = beginDate.getYear();
			  int beginMonth = beginDate.getMonth();
	
			  int endYear = endDate.getYear();
			  int endMonth = endDate.getMonth();
	
			  int difMonth = (endYear-beginYear)*12+(endMonth-beginMonth)+1;
			  
			  String year=begin.split("-")[0];
			  String month=begin.split("-")[1];
			  int monthCount=0;
			  
			  list.add(begin);
			  for(int i=1;i<difMonth;i++){
				  StringBuffer time=new StringBuffer();
				  monthCount=Integer.parseInt(month);
				  if(monthCount==12){
					  int yearNum=Integer.parseInt(year);
					  year=String.valueOf(yearNum+1);
					  
					  int monthNum=0;
					  month=String.valueOf(monthNum);
				  }
				  time.append(year+"-");
				  int monthNum=Integer.parseInt(month);
				  month=String.valueOf(monthNum+1);
				  if(month.length()<2){
					  month="0"+month;
				  }
				  time.append(month);
				  
				  list.add(time.toString());
				  
			  }
			  
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;

	  }
  
	  /**
	   * 得到年份
	   * @param begin
	   * @param end
	   * @return
	   */
	  public static List<String> getTwoYears(String begin, String end) {
		  List<String> list=new ArrayList<String>();
		  int startYear=Integer.parseInt(begin);
		  int endYear=Integer.parseInt(end);
		  int num=endYear-startYear;
		  list.add(begin);
		  for(int i=0;i<num;i++){
			  startYear=startYear+1;
			  list.add(String.valueOf(startYear));
		  }
		  return list;
	  }
	  
	  public static List<String> getYearAndQuarter(String begin, String end) {
		  List<String> list=new ArrayList<String>();
		  int startYear=Integer.parseInt(begin);
		  int endYear=Integer.parseInt(end);
		  int num=endYear-startYear;
		  String[] seasons={"年第一季度","年第二季度","年第三季度","年第四季度"};
		  for (int i=1;i<=4;i++) {
			  list.add(begin+seasons[i-1]);
			  if(begin.equals(getCurrentYear())){
				  if(getCurrentSeason()==i){
					  break;
				  }
			  }
		  }
		  
		  for(int i=0;i<num;i++){
			  startYear=startYear+1;
			  for (int j=1;j<=4;j++) {
				  list.add(String.valueOf(startYear)+seasons[j-1]);
				  if(String.valueOf(startYear).equals(getCurrentYear())){
					  if(getCurrentSeason()==j){
						  break;
					  }
				  }
			  }
		  }
		  return list;
	  }

	  /**
	   * 取得系统当前季度
	   * @return
	   */
	 private static int getCurrentSeason(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM");   
		long startTime = System.currentTimeMillis();  
		String time=sdf.format(new Date(startTime));
		int num=Integer.parseInt(time);
		if(1<=num && num<=3){
			return 1;
		}else if(4<=num && num<=6){
			return 2;
		}else if(7<=num && num<=9){
			return 3;
		}else {
			return 14;
		}
	 }
	 
	 private static  String getCurrentYear(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");   
		long startTime = System.currentTimeMillis();  
		return sdf.format(new Date(startTime));
	 }
	 
	 /**
	  * 获取去年同期日期
	  * 
	  * @param date     日期字符串  
	  * @param pattern  日期格式(yyyyMMdd)
	  * @return
	  */
	 public static String getPreYearDate(String date,String pattern) {
		
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date source = null;
		try {
			source = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(source);
		calendar.add(Calendar.YEAR, -1);
		Date convert = calendar.getTime();
		return format.format(convert);
	 }  
		/**
		 * 得到当前时间：YYYYMMDD HHMMSSmi
		 * @return
		 */
		public static String getCurrenttimemmm() {
			Calendar cal = Calendar.getInstance();
			String currentDatetime =
				new SimpleDateFormat("yyyyMMdd HHmmssSSS").format(cal.getTime());

			//System.out.println(currentDatetime);
			return currentDatetime;
		}
}
