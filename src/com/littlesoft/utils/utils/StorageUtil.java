package com.littlesoft.utils.utils;

import java.io.File;

import android.os.Environment;
import android.os.StatFs;

public class StorageUtil {
	public static boolean mounted(){
		return Environment.getExternalStorageState().equals("mounted");
	}
	public static File getExternalStorageDirectory(){
		return Environment.getExternalStorageDirectory();
	}

	public static String getExternalStorageDirectoryString(){
		return Environment.getExternalStorageDirectory().toString();
	}
	
	public static File getDownloadCacheDirectory(){
		return Environment.getDownloadCacheDirectory();
	}
	
	public static String getDownloadCacheDirectoryString(){
		return Environment.getDownloadCacheDirectory().toString();
	}
	
	public static String getDCIMDirectory(){
		return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString();
	}
	
	public static String getPictureDirectory(){
		return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
	}
	
	//copy from net from here now
	public static long getExternalStorageSpace() {

		long space = 0;
		try {
			StatFs stat = new StatFs(Environment.getExternalStorageDirectory()
					.getAbsolutePath());
			space = (long) stat.getAvailableBlocks()
					* (long) stat.getBlockSize();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return space;
	}

	public static boolean isExternalStorageExist() {
		return Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED) ? true : false;
	}

	public static float getLocalStorageSpace() {
		float space = 0;
		try {
			StatFs stat = new StatFs("/data/");
			space = stat.getAvailableBlocks() * (float) stat.getBlockSize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return space;
	}
}
