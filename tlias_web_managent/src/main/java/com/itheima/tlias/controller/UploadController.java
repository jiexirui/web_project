package com.itheima.tlias.controller;

import com.itheima.tlias.pojo.Result;
import com.itheima.tlias.util.AliyunOSSProperties;
import com.itheima.tlias.util.AliyunOSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @Autowired
    private AliyunOSSProperties aliyunOSSProperties;
//    @PostMapping("/upload")
//    public Result upload(@RequestParam("file") MultipartFile file) throws IOException {
//
//        // 获取上传文件的原始文件名,通过调用MultipartFile对象的getOriginalFilename()方法，获得用户上传文件时的原始文件名
//        String filename = file.getOriginalFilename();
//
//        // 生成UUID并移除横线，作为新的文件名,通过UUID.randomUUID()生成随机UUID,replace("-", "")移除横线
//        String uuid = UUID.randomUUID().toString().replace("-", "");
//
//        // 提取原始文件的扩展名（包含点号）
//        String substring = filename.substring(filename.lastIndexOf("."));
//
//        // 组合UUID和扩展名生成新的文件名
//        String newFileName = uuid + substring;
//
//        // 将上传的文件保存到指定路径（D盘根目录）transferTo()是Spring框架提供的方法，用于将MultipartFile对象中的文件内容写入到指定的目标文件路径中。
//        file.transferTo(new File("D:/" + newFileName));
//
//        // 返回成功结果
//        return Result.success();
//
//    }

    @PostMapping("/upload")
    //MultipartFile 是 Spring Framework 提供的接口，专门用于处理文件上传
    public Result upload(@RequestParam("file") MultipartFile file) throws Exception {
        String filename = file.getOriginalFilename();
        String substring = filename.substring(filename.lastIndexOf("."));
        String url = AliyunOSSUtils.upload(aliyunOSSProperties.getEndpoint(), aliyunOSSProperties.getBucketName(), file.getBytes(), substring);
        return Result.success(url);
    }
}
