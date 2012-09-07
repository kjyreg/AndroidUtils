package com.littlesoft.utils.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;

public class BitmapUtil {
    public static byte[] bitmapToByte(Bitmap bitmap){
        if(null == bitmap){
            return null;
        }
        byte[] bt = null;
        try {
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.PNG, 90, bs);
            
            bt = bs.toByteArray();
            bs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return bt;
    }
    
    public static Bitmap byteToBitmap(byte[] data){
        if(null == data || data.length == 0){
            return null;
        }
        return BitmapFactory.decodeByteArray(data, 0, data.length);
    }
    
    public static boolean exportJPG(Context context, String file, Bitmap bitmap){
        boolean r = false;
        boolean bsdcard = true;
        
        try {
            //存为PNG格式
            FileOutputStream fs = null;
            if( false==bsdcard ){
                fs = context.openFileOutput(file,Context.MODE_WORLD_READABLE|Context.MODE_WORLD_READABLE);
                bitmap.compress(CompressFormat.JPEG, 100, fs);
            }else{
                fs = new FileOutputStream( file, true );
                bitmap.compress(CompressFormat.JPEG, 100, fs);
            }
            
            fs.flush();
            fs.close();
            r = true;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return r;
    }
    
    public static boolean exportPNG(Context context,String file,Bitmap bitmap){
        boolean r = false;
        boolean bsdcard = true;
        
        try {
            //存为PNG格式
            FileOutputStream fs = null;
            if( false==bsdcard ){
                fs = context.openFileOutput(file,Context.MODE_WORLD_READABLE|Context.MODE_WORLD_READABLE);
                bitmap.compress(CompressFormat.PNG, 100, fs);
            }else{
                fs = new FileOutputStream( file, true );
                bitmap.compress(CompressFormat.PNG, 100, fs);
            }
            
            fs.flush();
            fs.close();
            r = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
}
