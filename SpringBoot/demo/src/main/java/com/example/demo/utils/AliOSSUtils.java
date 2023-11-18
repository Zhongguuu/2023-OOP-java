package com.example.demo.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.UUID;

/**
 * 阿里云 OSS 工具类
 */
@Component
public class AliOSSUtils {
    @Autowired
    private AliOSsProperties aliOSsProperties;
//    @Value("${aliyun.oss.endpoint}")
//    private String endpoint ;
//    private String accessKeyId = "LTAI4GCH1vX6DKqJWxd6nEuW";
//    private String accessKeySecret = "yBshYweHOpqDuhCArrVHwIiBKpyqSL";
//    @Value("${aliyun.oss.bucketName}")
//    private String bucketName ;

    /**
     * 实现上传图片到OSS
     */
    public String upload(MultipartFile file) throws IOException, ClientException {
        String bucketName=aliOSsProperties.getBucketName();
        String endpoint=aliOSsProperties.getEndpoint();
        // 获取上传的文件的输入流
        InputStream inputStream = file.getInputStream();

        // 避免文件覆盖
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        //上传文件到 OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
        ossClient.putObject(bucketName, fileName, inputStream);

        //文件访问路径
        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;
        // 关闭ossClient
        ossClient.shutdown();
        return url;// 把上传到oss的路径返回
    }

}
