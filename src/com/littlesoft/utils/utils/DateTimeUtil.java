package com.littlesoft.utils.utils;

import android.content.Context;
import android.text.format.DateUtils;
import android.text.format.Time;

public class DateTimeUtil {
	public static String getDate(Context context, long millis){
		return DateUtils.formatDateTime(context, millis, DateUtils.FORMAT_SHOW_DATE);
	}
	
	public static String getTime(Context context, long millis){
		return DateUtils.formatDateTime(context, millis, DateUtils.FORMAT_SHOW_TIME);
	}
	
	public static String getWeekDay(Context context, long millis){
		return DateUtils.formatDateTime(context, millis, DateUtils.FORMAT_SHOW_WEEKDAY);
	}
	
	public static void getToday(Context context){
		Time t = new Time();
		t.setToNow();
	}
}
