package com.example.demo.controller;

import com.example.demo.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class SessionController {
    @GetMapping("/c1")
    public Result cookie(HttpServletResponse response){
        response.addCookie(new Cookie("login_name","spring_boot"));
        return Result.success();
    }
    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login_name")){
                System.out.println("login_name: "+cookie.getValue());
            }
        }
        return Result.success();
    }
    @GetMapping("/s1")
    public Result session1(HttpSession httpSession){
        httpSession.setAttribute("loginUser","tom");
        return Result.success();
    }
    @GetMapping("/s2")
    public Result session2(HttpServletRequest request){
        HttpSession httpSession=request.getSession();
        Object loginUser=httpSession.getAttribute("loginUser");
        return Result.success(loginUser);
    }
}
