package com.example.demo.controller;

import com.example.demo.pojo.Emp;
import com.example.demo.service.EmpService;
import com.example.demo.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class loginController {
    @Autowired
    private EmpService empService;
    @PostMapping("/login")
    private Result login(@RequestBody Emp emp){
        log.info("员工登录：{}",emp);
        Emp e=empService.login(emp);
        if(e==null){
            return Result.error("用户名或密码错误");
        }
        else{
            return Result.success();
        }
    }
}
