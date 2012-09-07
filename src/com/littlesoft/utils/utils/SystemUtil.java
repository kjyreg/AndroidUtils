package com.littlesoft.utils.utils;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.os.Build;

public class SystemUtil {
	public static boolean isServiceRunning(Context context, String serviceName){
		ActivityManager am = (ActivityManager) context.getSystemService("activity");
		List<RunningServiceInfo> rs = am.getRunningServices(100);
		for(RunningServiceInfo si : rs){
			if( si.service.getClassName().equals(serviceName)){
				return true;
			}
		}
		
		return false;
	}

	public static int getSDKVersionNumber() {
		return Build.VERSION.SDK_INT;
	}
}