package com.example.demo.service.impl;

import com.example.demo.mapper.DeptMapper;
import com.example.demo.pojo.Dept;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        System.out.println(dept.getName()+dept.getUpdateTime());
        deptMapper.insert(dept);
    }

}
