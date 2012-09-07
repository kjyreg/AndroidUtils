package com.littlesoft.utils.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionUtil {
	public static boolean checkNet(Context context) {
		try {
			ConnectivityManager connManager = (ConnectivityManager) context.getSystemService("connectivity");
			if (connManager != null) {
				NetworkInfo netInfo = connManager.getActiveNetworkInfo();
				if ((netInfo != null) && (netInfo.isConnected())) {
					if (netInfo.getState() == NetworkInfo.State.CONNECTED) {
						return true;
					} 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public static boolean isMobile(Context context){
		NetworkInfo netInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
		if ((netInfo != null) && (netInfo.getType() == 0)){
			return true;
		}
		return false;
	}
	
	public static boolean isWifi(Context context){
		NetworkInfo netInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
		if ((netInfo != null) && (netInfo.getType() == 1)){
			return true;
		}
		return false;
	}
	
	public static boolean isWiFiActive(Context context) {
		try{
			ConnectivityManager connManager = (ConnectivityManager) context.getSystemService("connectivity");
			NetworkInfo[] arrayOfNetworkInfo;
			if (connManager != null) {
				arrayOfNetworkInfo = connManager.getAllNetworkInfo();
				if( arrayOfNetworkInfo != null){
					for(NetworkInfo info : arrayOfNetworkInfo){
						if( info.getTypeName().equals("WIFI") && info.isConnected()){
							return true;
						}
					}
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
