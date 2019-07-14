package com.example.methods;

import java.io.*;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/**
 * @author : zhaojh
 * @date : 2019-07-12
 * @function :MD5 文件的加密与解密
 */

public class MD5Test {


    private static String value =null;
    private static File file=null;


    public static void main(String[] args) {





        file = new File("D:\\a.txt");
        value = MD5Test.getMd5ByFile(file);
        System.out.println(value);

        file = new File("D:\\b.txt");
        value = MD5Test.getMd5ByFile(file);
        System.out.println(value);

        file = new File("D:\\c.txt");
        value = MD5Test.getMd5ByFile(file);
        System.out.println(value);

        file = new File("D:\\d.txt");
        value = MD5Test.getMd5ByFile(file);
        System.out.println(value);
    }

    //对文件的加密处理

    /**
     * 加密文件 2019年7月12日
     * 得到一个MD5 加密的字符串
     * */
    public static String getMd5ByFile(File file) {
        String value = null;
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md5 = MessageDigest.getInstance(("MD5"));
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    /**
     * 解密
     */
}
