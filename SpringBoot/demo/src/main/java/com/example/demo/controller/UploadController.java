package com.example.demo.controller;

import com.aliyuncs.exceptions.ClientException;
import com.example.demo.pojo.Result;
import com.example.demo.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {

/*    public Result upload(MultipartFile image) throws Exception {
        //log.info("进行文件上传：{}，{}，{}",username,age,image);
        //获取原始文件名
        String namee=image.getOriginalFilename();
        int index =namee.lastIndexOf('.');
        namee=namee.substring(index);
        String newName= UUID.randomUUID().toString()+namee;
        log.info("新的文件名：{}",newName);
        image.transferTo(new File("E:\\资料\\image\\"+newName));
        return Result.success();
    }*/
    @Autowired
    private AliOSSUtils aliOSSUtils;
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException, ClientException {
        log.info("文件上传：{}",image.getOriginalFilename());
        String url=aliOSSUtils.upload(image);
        log.info("文件上传完成 访问的url为：{}",url);
        return Result.success(url);
    }
}
