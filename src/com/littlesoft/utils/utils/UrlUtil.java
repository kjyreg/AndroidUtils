package com.littlesoft.utils.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlUtil {
	public String decodeUrl(String url){
		try{
			return URLDecoder.decode(url,"utf-8");
		} catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public String encodeUrl(String url){
		try{
			return URLEncoder.encode(url, "utf-8");
		} catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean isUrlEncoded(String url){
		if(url == null || "".equals(url)){
			return false;
		}
		
		char[] chrs =  url.toCharArray();
		
		return false;
	}
}
