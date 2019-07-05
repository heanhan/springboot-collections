package com.example.common.utils;

import java.io.*;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;

public class UpPhotoUtil {
    /**
     * 字符串转图片
     *
     * @param imgStr
     *            --->图片字符串
     * @param filename
     *            --->图片名
     * @return
     */
    public static boolean generateImage(String imgStr, String filename) {

        if (imgStr == null) {
            return false;
        }
        Base64 decoder = new Base64();
        try {
            // 解密
            byte[] b = decoder.decode(imgStr);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(filename);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }

    /**
     * 图片转字符串
     *
     * @param filePath
     *            --->文件路径
     * @return
     */
    public static String getImageStr(String filePath) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(filePath);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        Base64 encoder = new Base64();
        return encoder.encodeAsString(data);
    }

    /*
     * 测试代码
     */
    public static void main(String[] args) {
        File file = new File("E:" + File.separator + "lp_platformdate" + File.separator + "photo");
        String[] files = null;
        files = file.list();
        System.out.println("取到的list大小：" + files.length);
        for (int i = 0; i < 1; i++) {
            String strurl = "E:\\lp_platformdate\\photo\\" +files[i];

            System.out.println("--------分割线-------------------");
            String strPwd = getImageStr(strurl);
            System.out.println("加密后的图片字符串：" + strPwd);
        }

    }

}
