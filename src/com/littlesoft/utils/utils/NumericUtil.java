package com.littlesoft.utils.utils;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class NumericUtil {
    public static byte[] floatToByte(float[] f,int len){
        try{
            ByteBuffer bb = ByteBuffer.allocateDirect(len * 4);
            for(int i = 0; i < len; i++){
                bb.putFloat(f[i]);
            }
            bb.position(0);
            byte[] b = new byte[len * 4];
            bb.get(b);
            return b;
        }catch(Exception e){
        	e.printStackTrace();
            return null;
        }
    }
    
    public static float[] byteToFloat(byte[] b,int len){
        try{
            ByteBuffer bb = ByteBuffer.wrap(b);
            FloatBuffer fb = bb.asFloatBuffer();
            float[] f = new float[len];
            fb.get(f);
            return f;
        }catch(Exception e){
        	e.printStackTrace();
            return null;
        }
    }
}
