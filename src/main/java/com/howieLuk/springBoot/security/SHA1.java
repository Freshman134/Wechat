package com.howieLuk.springBoot.security;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA1加密算法
 */
public class SHA1 implements Encory {

    private String charset;

    public SHA1() {
        charset = "UTF-8";
    }

    public SHA1(String charset) {
        this.charset = charset;
    }

    @Override
    public String encode(String message) {
        String secret = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte [] byteArray = md.digest(message.getBytes(charset));
            secret = byteToStr(byteArray);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return secret;
    }

    private static String byteToStr(byte [] byteArray) {

        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;

    }

    public static void main(String [] args) {
        Encory sha1 = new SHA1();
        String message = "Hello, World!";
        String secret = "0a0a9f2a6772942557ab5355d76af442f8f65e01".toUpperCase(); //因为大小写没有区别
        String test = sha1.encode(message);
        if (test.equals(secret)) {
            System.out.println("加密正确!");
        } else {
            System.out.println("加密失败!");
            System.out.println("明文：" + message);
            System.out.println("正确密文：" + secret);
            System.out.println("输出密文：" + test);
        }
    }
}
