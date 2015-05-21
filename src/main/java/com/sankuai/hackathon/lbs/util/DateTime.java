package com.sankuai.hackathon.lbs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateTime {

    public static final String DATAFORMAT_ISO8601 = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String DATAFORMAT_UTC = "yyyy-MM-dd'T'HH:mm:ss'+08:00'";
    public static final String DATAFORMAT_UTC_DATE = "yyyy-MM-dd'T00:00:00+08:00'";

    public static final String DATAFORMAT_DATE = "yyyy-MM-dd";
    public static final String DATAFORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

    public static final String DATAFORMAT_GMT = "EEE, d MMM yyyy HH:mm:ss 'GMT'";


    private Calendar calendar;

    private DateTime() {
        this.calendar = Calendar.getInstance();

    }

    private DateTime(Date date) {
        this.calendar = Calendar.getInstance();
        this.calendar.setTime(date);
    }

    public static DateTime parse(Date date) {
        return new DateTime(date);
    }

    public static DateTime parse(String source) {
        String pattern = "yyyy-MM-dd";
        if (source.contains(":")) {
            pattern += " HH:mm:ss";
        }
        return parse(source, pattern);
    }

    public static DateTime parse(String source, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        DateTime dt = new DateTime();
        try {
            dt.calendar.setTime(format.parse(source));
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
        return dt;
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.US);
        return format.format(date);
    }

    public static DateTime now() {
        return new DateTime();
    }

    public static DateTime addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + days);
        return new DateTime(calendar.getTime());
    }

    public static TimeSpan diff(Date date1, Date date2) {
        long time = 0;
        if (date1 != null && date2 != null) time = date1.getTime() - date2.getTime();
        return new TimeSpan(time);
    }

    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return toString(DATAFORMAT_DATETIME);
    }

    public String toString(String pattern) {
        return format(this.calendar.getTime(), pattern);
    }

    public String toGMTString() {
        return toString(DATAFORMAT_GMT);
    }

    public String toUTCString() {
        return toString(DATAFORMAT_UTC);
    }

    public java.sql.Date toSqlDate() {
        return new java.sql.Date(dateFormat().toDate().getTime());
    }

    public java.sql.Timestamp toSqlTimestamp() {
        return new java.sql.Timestamp(this.calendar.getTimeInMillis());
    }

    public java.sql.Time toSqlTime() {
        return new java.sql.Time(this.calendar.getTimeInMillis());
    }

    public Date toDate() {
        return this.calendar.getTime();
    }

    public DateTime dateFormat() {
        this.calendar = new GregorianCalendar(getYear(), getMonth() - 1, getDay());
        return this;
    }


    public long timeStamp() {
        return this.calendar.getTimeInMillis();
    }

    public DateTime addDays(int days) {
        if (days != 0) this.calendar.add(Calendar.DATE, days);
        return this;
    }

    public int dayOfWeek() {
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (week == 0) week = 7;
        return week;
    }

    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    public int getMonth() {
        return calendar.get(Calendar.MONTH) + 1;
    }

    public int getDay() {
        return calendar.get(Calendar.DATE);
    }


    public static class TimeSpan {
        private int days;
        private int hours;
        private int minutes;
        private long seconds;
        private long milliseconds;

        private double totalDays;
        private double totalHours;
        private double totalMinutes;
        private double totalSeconds;
        private double totalMilliseconds;

        public TimeSpan(long millisecond) {
            this.totalMilliseconds = millisecond;
            this.totalSeconds = millisecond / 1000.0;
            this.totalMinutes = millisecond / (60 * 1000.0);
            this.totalHours = millisecond / (60 * 60 * 1000.0);
            this.totalDays = millisecond / (24 * 60 * 60 * 1000.0);

            this.milliseconds = millisecond % 1000;
            this.seconds = millisecond % (60 * 1000) / 1000;
            this.minutes = (int) millisecond % (60 * 60 * 1000) / (60 * 1000);
            this.hours = (int) millisecond % (24 * 60 * 60 * 1000) / (60 * 60 * 1000);
            this.days = (int) millisecond / (24 * 60 * 60 * 1000);
        }

        @Override
        public String toString() {
            String str = String.format("%s天  %s小时  %s分钟  %s秒  %s毫秒", this.totalDays, this.totalHours, this.totalMinutes, this.totalSeconds, this.totalMilliseconds);
            str += String.format("\r\n%s天 %s小时 %s分钟 %s秒 %s毫秒", this.days, this.hours, this.minutes, this.seconds, this.milliseconds);
            return str;
        }

        public int getDays() {
            return days;
        }

        public int getHours() {
            return hours;
        }

        public int getMinutes() {
            return minutes;
        }

        public long getSeconds() {
            return seconds;
        }

        public long getMilliseconds() {
            return milliseconds;
        }

        public double getTotalDays() {
            return totalDays;
        }

        public double getTotalHours() {
            return totalHours;
        }

        public double getTotalMinutes() {
            return totalMinutes;
        }

        public double getTotalSeconds() {
            return totalSeconds;
        }

        public double getTotalMilliseconds() {
            return totalMilliseconds;
        }
    }
}
