package com.littlesoft.utils.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

public class DeviceUtil {
	public static void setDeviceId(Context context) {
		String imei = getIMEI(context);
		Properties props = new Properties();
		props.setProperty("deviceid", String.valueOf(imei));
		
		try {
			FileOutputStream fos = context.openFileOutput("settings.properties", 2);
			props.store(fos, null);
			return;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	  
	public static String getDeviceId(Context context){
		Properties prop = new Properties();
		try{
			FileInputStream is = context.openFileInput("settings.properties");
			prop.load(is);
			return prop.getProperty("deviceid");
		} catch (Exception e){
			
		}
		return null;
	}
	
	public static String getIMEI(Context context){
		return ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
	}
	
	public static String getDeviceModel(){
		return Build.MODEL;
	}
}
