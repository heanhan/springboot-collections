package com.example.pdf.utils;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author : zhaojh
 * @date : 2019-07-18
 * @function :  调用打印机 服务
 */

public class PrintUtil {

    /**
     * <p>Description:打印合规文件 </p>
     *
     * @param imgPath
     * @return
     */
    public static int printOrderImgInfo(String imgPath) {
        File file = new File(imgPath);
        // 构建打印请求属性集
        HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        // 设置打印格式
        DocFlavor flavor = DocFlavor.INPUT_STREAM.PNG;
        // 查找所有的可用的打印服务
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(
                flavor, pras);
        // 定位默认的打印服务
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        // 显示打印对话框
        PrintService service = ServiceUI.printDialog(null, 200, 200, printService, defaultService, flavor, pras);
        if (service != null) {
            try {
                DocPrintJob job = service.createPrintJob();
                FileInputStream fis = new FileInputStream(file);
                DocAttributeSet das = new HashDocAttributeSet();
                Doc doc = new SimpleDoc(fis, flavor, das);
                job.print(doc, pras);
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 1;
    }


    public static void main(String[] args) {
        //调用本地打印机
        String path="D:\\springboot-collections\\springboot-pdf\\测试打印.docx";
        int i = PrintUtil.printOrderImgInfo(path);
        if(i>0){
            System.out.println("打印成功！");
        }else{
            System.out.println("打印失败！");
        }

    }
}
