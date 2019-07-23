package com.example.springbootfastdfs.fastdfs;

import lombok.Data;

/**
 * @author : zhaojh
 * @date : 2019-07-22
 * @function :
 */

@Data
public class FastDFSFile {

    private String name;  //文件名

    private byte[] content; //文件内容

    private String ext;

    private String md5;//md5加密

    private String author;//作者

    public FastDFSFile(String name, byte[] content, String ext, String height,
                       String width, String author) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.author = author;
    }

    public FastDFSFile(String name, byte[] content, String ext) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;

    }
}
