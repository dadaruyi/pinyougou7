package com.pinyougou.shop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import entity.Result;
import util.FastDFSClient;

@RestController
public class UploadController {

    @Value("${FILE_SERVER_URL}")
    private String file_server_url;

    @RequestMapping("/upload")
    public Result upload(MultipartFile file){

        String originalFilename = file.getOriginalFilename();//获取文件名
        String extName=originalFilename.substring( originalFilename.lastIndexOf(".")+1);//得到扩展名

        try {
            FastDFSClient client=new FastDFSClient("classpath:config/fdfs_client.conf");
            String fileId = client.uploadFile(file.getBytes(), extName);
            String url=file_server_url+fileId;//图片完整地址
            return new Result(true, url);

        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "上传失败");
        }

    }


}

/*
package com.pinyougou.shop.controller;

import entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import util.FastDFSClient;


*/
/**
 * 文件上传Controller
 *//*

@RestController
public class UploadController {

    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;//文件服务器地址
    @RequestMapping("/upload")
    public Result upload(MultipartFile file)  {
        //1 取文件的扩展名
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        //分割获取文件扩展名 indexOf(".")代表最后一个.和后面的全部  +1则代表不包含“.”
        String extName = originalFilename.substring(originalFilename.indexOf(".") + 1);
        //2 创建一个FastDFSClient的客户端
        FastDFSClient fastDFSClient = null;
        try {
            fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.config");

        //3 执行上传
        String path = fastDFSClient.uploadFile(file.getBytes(), extName);
        //4 拼接返回的URL和IP地址   拼成完整的URl
        String url=FILE_SERVER_URL+path;
        return new Result(true,url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false,"上传失败");
    }
    }

*/
