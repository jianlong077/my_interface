package com.haichao.date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class DateUtil {
	private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

	public DateUtil() {
	}

	/**
	 * 获取当前时间
	 * 
	 * @param format
	 * @return
	 */
	public static String now(String format) {
		if (StringUtils.isEmpty(format)) {
			format = "yyyy-MM-dd HH:mm:ss";
		}

		SimpleDateFormat f = new SimpleDateFormat(format);
		return f.format(new Date());
	}

	/**
	 * 获取当前日期 字符型
	 * 
	 * @return
	 */
	public static String date() {
		String format = "yyyy-MM-dd";
		SimpleDateFormat f = new SimpleDateFormat(format);
		return f.format(new Date());
	}

	/**
	 * 获取当前日期Date型
	 * 
	 * @return
	 */
	public static Date currentDate() {
		String format = "yyyy-MM-dd";
		SimpleDateFormat f = new SimpleDateFormat(format);
		String d = f.format(new Date());
		return getDateFromString(d, format);
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static Date now() {
		return new Date();
	}

	/**
	 * 获取的当前时间毫秒
	 * 
	 * @return
	 */
	public static long nowMillis() {
		return System.currentTimeMillis();
	}

	/**
	 * 字符转日期
	 * 
	 * @param str
	 * @param fm
	 * @return
	 */
	public static Date StrToDate(String str, String fm) {
		if (StringUtils.isEmpty(fm)) {
			fm = "yyyy-MM-dd HH:mm:ss";
		}

		if (str != null) {
			SimpleDateFormat format = new SimpleDateFormat(fm);
			Date date = null;

			try {
				date = format.parse(str);
			} catch (ParseException var5) {
				log.error("", var5);
			}

			return date;
		} else {
			return null;
		}
	}

	public static String taskDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("s m H d M ? yyyy");
		Date now = new Date();
		String cron = null;
		if (now.getTime() > date.getTime()) {
			cron = sdf.format(new Date(now.getTime() + 5000L));
		} else {
			cron = sdf.format(date);
		}

		return cron;
	}

	/**
	 * 日期转字符
	 * 
	 * @param sourceDate
	 * @param format
	 * @return
	 */
	public static String formatDate(Date sourceDate, String format) {
		if (sourceDate == null) {
			return "";
		} else {
			if (null ==format && format.isEmpty()) {
				format = "yyyy-MM-dd HH:mm:ss";
			}

			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sourceDate);
			return dateFormat.format(calendar.getTime());
		}
	}

	public static Date getAddDate(Date sourceDate, int type, int count) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sourceDate);
		calendar.add(type, count);
		return calendar.getTime();
	}

	/**
	 * 当前日期加天数
	 * 
	 * @param sourceDate
	 * @param day
	 * @return
	 */
	public static Date getAddDateByDay(Date sourceDate, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sourceDate);
		calendar.add(5, day);
		return calendar.getTime();
	}

	/**
	 * 当前日期加秒
	 * 
	 * @param sourceDate
	 * @param second
	 * @return
	 */
	public static Date getAddDateBySecond(Date sourceDate, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sourceDate);
		calendar.add(13, second);
		return calendar.getTime();
	}

	/**
	 * 当前日期加秒格式化返回字符
	 * 
	 * @param sourceDate
	 * @param second
	 * @param format
	 * @return
	 */
	public static String getAddDateBySecond(Date sourceDate, int second, String format) {
		if (format.isEmpty()) {
			format = "yyyy-MM-dd HH:mm:ss";
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(getAddDateBySecond(sourceDate, second));
	}

	/**
	 * 字符日期转date
	 * 
	 * @param k
	 * @param dateformat
	 * @return
	 */
	public static Date getDateFromString(String k, String dateformat) {
		if (dateformat.isEmpty()) {
			dateformat = "yyyy-MM-dd HH:mm:ss";
		}

		try {
			SimpleDateFormat format = new SimpleDateFormat(dateformat);
			format.setLenient(false);
			return format.parse(k);
		} catch (ParseException var3) {
			return null;
		}
	}

	/**
	 * 字符日期转date
	 * 
	 * @param k
	 * @return
	 */
	public static Date getDateFromString(String k) {
		return getDateFromString(k, "yyyy-MM-dd HH:mm:ss");
	}

	public static boolean checkDate(String k, String dateformat) {
		return getDateFromString(k, dateformat) != null;
	}

	/**
	 * 当前日期比较（yyyy-MM-dd HH:mm:ss）
	 * @return
	 */
	public static long dateTimeCompare(String sdate, String edate) {
		long day = 0L;

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date begin_date = format.parse(sdate);
			Date end_date = format.parse(edate);
			day = (end_date.getTime() - begin_date.getTime()) / 1000L;
			return day;
		} catch (Exception var7) {
			return -1L;
		}
	}

	/**
	 * 当前日期比较（yyyy-MM-dd）
	 * @return
	 */
	public static long dateCompare(String sdate, String edate) {
		long day = 0L;

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date begin_date = format.parse(sdate);
			Date end_date = format.parse(edate);
			day = (end_date.getTime() - begin_date.getTime()) / 86400000L;
			return day;
		} catch (Exception var7) {
			return -1L;
		}
	}

	/**
	 * 当前日期比较（由毫秒开始）
	 * 
	 * @param sdate
	 * @param edate
	 * @return
	 */

	public static long dateTimeCompare(Date sdate, Date edate) {
		long day = (edate.getTime() - sdate.getTime()) / 1000L;
		return day;
	}

	/**
	 * 当前日期比较（由毫秒开始）
	 * 
	 * @param sdate
	 * @param edate
	 * @return
	 */
	public static long getDateDiffSecond(String sdate, String edate) {
		long day = 0L;

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date begin_date = format.parse(sdate);
			Date end_date = format.parse(edate);
			day = (end_date.getTime() - begin_date.getTime()) / 1000L;
			return day;
		} catch (Exception var7) {
			return -1L;
		}
	}
	public static double getDateDiffSecond(Long sdate, Long edate) {
		double diffSecond = 0L;

		try {
			diffSecond = (edate - sdate) / 1000.0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diffSecond;
	}
	/**
	 * 
	 * @param sdate
	 * @param edate
	 * @return
	 */
	public static long getDateDiffSecond(Date sdate, Date edate) {
		long day = 0L;

		try {
			day = (edate.getTime() - sdate.getTime()) / 1000L;
			return day;
		} catch (Exception var5) {
			return -1L;
		}
	}

	public static String getWeekOfDate(Date date) {
		String[] weekOfDays = new String[] { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}

		int w = calendar.get(7) - 1;
		if (w < 0) {
			w = 0;
		}

		return weekOfDays[w];
	}

	/**
	 * 获得当前是一周的第几天 周一 是1 周二是2....周日是7
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekIndexOfDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}

		int w = calendar.get(7) - 1;
		if (w < 0) {
			w = 0;
		}

		return w == 0 ? 7 : w;
	}

	public static String getWeekOfDate(int weekIndex) {
		String[] weekOfDays = new String[] { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		return weekIndex >= 0 && weekIndex <= 6 ? weekOfDays[weekIndex] : "";
	}

	public static String getShortWeekOfDate(int weekIndex) {
		String s = getWeekOfDate(weekIndex);
		return s.replace("星期", "周");
	}

	public static String getShortWeekOfDate(Date date) {
		String s = getWeekOfDate(date);
		return s.replace("星期", "周");
	}

	public static String formatDateChina(String SourceDate, String format) {
		Date d = new Date(dateToTimestamp(SourceDate) * 1000L);
		if (format.isEmpty()) {
			format = "MM月dd日";
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return dateFormat.format(calendar.getTime());
	}

	public static long dateToTimestamp(String dateString) {
		return dateToTimestamp(dateString, "yyyy-MM-dd HH:mm:ss");
	}

	public static long dateToTimestamp(String dateString, String format) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(format);

			Date date;
			try {
				date = df.parse(dateString);
			} catch (ParseException var6) {
				df = new SimpleDateFormat("yyyy-MM-dd");
				date = df.parse(dateString);
			}

			long s = date.getTime();
			return s / 1000L;
		} catch (ParseException var7) {
			var7.printStackTrace();
			return 0L;
		}
	}

	public static String getDateName(String date) {
		if (date != null && !date.isEmpty()) {
			int l = (int) getDateDiff(date(), date);
			if (l == 0) {
				return "今日";
			} else if (l == 1) {
				return "明日";
			} else {
				return l == 2 ? "后日" : formatDateChina(date, "M月d日");
			}
		} else {
			return "7日后";
		}
	}

	/**
	 * 求两个日期相差多少天
	 * 
	 * @param sdate
	 * @param edate
	 * @return
	 */
	public static long getDateDiff(String sdate, String edate) {
		long day = 0L;

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date begin_date = format.parse(sdate);
			Date end_date = format.parse(edate);
			day = (end_date.getTime() - begin_date.getTime()) / 86400000L;
			return day;
		} catch (Exception var7) {
			return -1L;
		}
	}

    /**
     * 获取某个月某周的开始时间结束时间
     * @param str
     * @return
     */
    public static Map<Integer,String> weeks(String str) {
        Map<Integer,String> map=new HashMap<Integer, String>();
        // Java8  LocalDate
        try{
            LocalDate date = LocalDate.parse(str);

            // 该月第一天
            LocalDate firstDay = date.with(TemporalAdjusters.firstDayOfMonth());
            // 该月最后一天
            LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
            // 该月的第一个周一
            LocalDate start = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

            List<String> list = new ArrayList<>();

            // 处理每个月的1号不是周一的情况
            int i=0;
            if (!firstDay.equals(start)) {
                i++;
                StringBuilder strbur = new StringBuilder();
                strbur.append(firstDay.toString())
                        .append("至")
                        .append(start.plusDays(-1).toString());
                list.add(strbur.toString());
                map.put(i,strbur.toString());
            }

            while (start.isBefore(lastDay)) {
                i++;
                StringBuilder strbur = new StringBuilder();
                strbur.append(start.toString());

                LocalDate temp = start.plusDays(6);
                if (temp.isBefore(lastDay)) {

                    strbur.append("至")
                            .append(temp.toString());
                } else {

                    strbur.append("至")
                            .append(lastDay.toString());
                }

                list.add(strbur.toString());
                map.put(i,strbur.toString());
                start = start.plusWeeks(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
    //一个月都有多少天
    public static String getDaysOfMonth(Date date) {

        Calendar calendar =Calendar.getInstance();

        calendar.setTime(date);

        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH)+"";

    }
    public static String getMonth(Date date) {
        return formatDate(date,"yyyyMM");
    }
    public static String getSeason(Date date) {
        String year= formatDate(date,"yyyy");
        String month= formatDate(date,"M");
        BigDecimal season = new BigDecimal(month).divide(new BigDecimal(3),0,BigDecimal.ROUND_UP);
        return year+"0"+season.intValue();
    }

    public static void main(String[] args) {
        System.out.println("当前时间所在月 "+getMonth(new Date()));
        System.out.println("当前时间所在月有多少天 "+getDaysOfMonth(new Date()));
        System.out.println("当前时间所在季度 "+getSeason(new Date()));
        System.out.println("日历每月有多少周 每周的开始和结束是啥 "+weeks("2021-12-07"));
    }
}
