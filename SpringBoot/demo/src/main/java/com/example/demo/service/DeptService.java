package com.example.demo.service;

import com.example.demo.pojo.Dept;

import java.util.List;

public interface DeptService {
    //查询全部部门数据
    List<Dept> list();
    //用来删除部门

    void delete(Integer id);

    //新增部门
    void add(Dept dept);
}
