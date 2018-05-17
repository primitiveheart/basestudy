package com.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by admin on 2018/5/17.
 */
public class MD5Utils {

    public static String md5(String message){
        try{
            MessageDigest md =  MessageDigest.getInstance("md5");
            byte[] b = md.digest();

            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(b);
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }

    public static String base64Encoder(String str){
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(str.getBytes());
    }

    public static String base64Decoder(String str) {
        BASE64Decoder decoder = new BASE64Decoder();
        String decode = "";
        try{
            decode = decoder.decodeBuffer(str).toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return decode;
    }

    public static void main(String[] args){
        System.out.println(md5("123"));
    }
}
