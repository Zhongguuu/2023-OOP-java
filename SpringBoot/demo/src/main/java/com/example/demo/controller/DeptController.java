package com.example.demo.controller;

import com.example.demo.pojo.Dept;
import com.example.demo.pojo.Result;
import com.example.demo.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    //private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;
    @GetMapping
    public Result list() {
        log.info("查询全部部门信息");

        //调用Service查询部门数据
        List<Dept>deptList=deptService.list();
        return Result.success(deptList);
    }
    @DeleteMapping("/{id}")
    //删除部门
    public Result delete(@PathVariable Integer id){
        log.info("根据路径删除部门：{}",id);
        //调用Service层删除数据
        deptService.delete(id);
        return Result.success();
    }
    //新增部门
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }
}
