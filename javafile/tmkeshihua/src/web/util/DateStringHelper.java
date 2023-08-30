package web.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateStringHelper {
	private DateStringHelper() {

	}

	public static Date Min() {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(0);
		return c.getTime();
	}

	public static Date Max() {
		Calendar c = Calendar.getInstance();
		c.set(9998, 11, 31);
		return c.getTime();
	}

	// 获取日期时间的日期部分，时间部分清零
	public static Date clearTime(Date begin) {
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.MILLISECOND, 0);
		begin = c.getTime();
		return begin;
	}

	/**
	 * 将字符串转换为日期类�?
	 * 
	 * @param date
	 *            日期时间字符�?
	 * @param format
	 *            SimpleDateFormat 支持的标准格式串
	 * @return
	 */
	public static Date parseOrNow(String date, String format) {
		if (date != null) {
			try {
				DateFormat df = new SimpleDateFormat(format);
				return df.parse(date);
			} catch (ParseException ex) {
				//WebLogger.err(ex,IDateUtil.class);//
				////e.printStackTrace();
			}
		}
		return new Date();
	}

	public static Date parseOrMax(String date, String format) {
		if (date != null) {
			//WebLogger.log(date);
			try {
				DateFormat df = new SimpleDateFormat(format);
				return df.parse(date);
			} catch (ParseException ex) {
				//WebLogger.err(ex,IDateUtil.class);//
				//e.printStackTrace();
			}
		}
		return Max();
	}

	public static Date parseOrMin(String date, String format) {
		if (date != null) {
			//WebLogger.log(date);
			try {
				DateFormat df = new SimpleDateFormat(format);
				return df.parse(date);
			} catch (ParseException ex) {
				//WebLogger.err(ex,IDateUtil.class);//
				//e.printStackTrace();
			}
		}
		return Min();
	}
	public static Date getBegin(Date dt) {
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
	
		c.set(Calendar.HOUR,0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND,0);
		return c.getTime();
	}
	public static Date getEnd(Date dt) {
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.set(Calendar.HOUR,23);
		c.set(Calendar.MINUTE,59);
		c.set(Calendar.SECOND,59);
		c.set(Calendar.MILLISECOND,999);
		return c.getTime();
	}
	public static Date IncrementDays(Date dt, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, days);
		return c.getTime();
	}
	public static Date IncrementSecond(Date dt, int second) {
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.SECOND, second);
		return c.getTime();
	}
	public static Date IncrementMinute(Date dt, int minute) {
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.MINUTE, minute);
		return c.getTime();
	}

	private static String shortDate = "y/M/d";
	private static String longDate = "yyyy/MM/dd";

	private static String shortTime = "H:m:s";
	private static String longTime = "HH:mm:ss";

	private static String shortTime_s = "H:m:s:S";
	private static String longTime_s = "HH:mm:ss:SSS";

	private static String shortDateTime = "y/M/d H:m:s";
	private static String longDateTime = "yyyy/MM/dd HH:mm:ss";

	private static String shortDateTime_s = "y/M/d H:m:s:S";
	private static String longDateTime_s = "yyyy/MM/dd HH:mm:ss:SSS";

	private final static SimpleDateFormat format = new SimpleDateFormat();

	/*********************************************************************/
	public static String getString(Date dt, String formatString) {
		format.applyPattern(formatString);
		return format.format(dt);
	}

	/*********************************************************************/
	public static String getShortDateString(Date dt) {
		format.applyPattern(shortDate);
		return format.format(dt);
	}

	public static String getShortDateString(Calendar c) {
		return getShortDateString(c.getTime());
	}

	/*********************************************************************/
	public static String getLongDateString(Date dt) {
		format.applyPattern(longDate);
		return format.format(dt);
	}

	public static String getLongDateString(Calendar c) {
		return getLongDateString(c.getTime());
	}

	/*********************************************************************/
	public static String getShortTimeString(Date dt) {
		format.applyPattern(shortTime);
		return format.format(dt);
	}

	public static String getShortTimeString(Calendar c) {
		return getShortTimeString(c.getTime());
	}

	public static String getShortTimeString_s(Date dt) {
		format.applyPattern(shortTime_s);
		return format.format(dt);
	}

	public static String getShortTimeString_s(Calendar c) {
		return getShortTimeString(c.getTime());
	}

	/*********************************************************************/
	public static String getLongTimeString(Date dt) {
		format.applyPattern(longTime);
		return format.format(dt);
	}

	public static String getLongTimeString(Calendar c) {
		return getLongTimeString(c.getTime());
	}

	public static String getLongTimeString_S(Date dt) {
		format.applyPattern(longTime_s);
		return format.format(dt);
	}

	public static String getLongTimeString_S(Calendar c) {
		return getLongTimeString(c.getTime());
	}

	/*********************************************************************/
	public static String getShortDateTimeString(Date dt) {
		format.applyPattern(shortDateTime);
		return format.format(dt);
	}

	public static String getShortDateTimeString(Calendar c) {
		return getShortDateTimeString(c.getTime());
	}

	public static String getShortDateTimeString_S(Date dt) {
		format.applyPattern(shortDateTime_s);
		return format.format(dt);
	}

	public static String getShortDateTimeString_S(Calendar c) {
		return getShortDateTimeString(c.getTime());
	}

	/*********************************************************************/
	public static String getLongDateTimeString(Date dt) {
		format.applyPattern(longDateTime);
		return format.format(dt);
	}

	public static String getLongDateTimeString(Calendar c) {
		return getLongDateString(c.getTime());
	}

	public static String getLongDateTimeString_S(Date dt) {
		format.applyPattern(longDateTime_s);
		return format.format(dt);
	}

	public static String getLongDateTimeString_s(Calendar c) {
		return getLongDateString(c.getTime());
	}

	

}
