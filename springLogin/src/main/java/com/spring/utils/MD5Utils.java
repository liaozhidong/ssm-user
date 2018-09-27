package com.spring.utils;

import java.security.MessageDigest;

/**
 * lzd
 */

public class MD5Utils {

    private static final String hexDigIts[] = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    /**
     * MD5加密
     */
    public static  String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (null== charsetname || "".equals(charsetname)) {
            resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            }else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        }catch (Exception e) {
        }
        return resultString;
    }

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<b.length ;i++) {
            sb.append(byteAToHexString(b[i]));
        }
        return  sb.toString();
    }

    private static String byteAToHexString(byte b) {
        int n= b;
        if (n<0){
            n+=256;
        }
        int d1 = n /16;
        int d2 = n %16;
        return hexDigIts[d1]+hexDigIts[d2];
    }

    public static void main(String[] args) {
        String name = "123";
        System.out.println(MD5Encode(name,"UTF-8"));
    }

}
