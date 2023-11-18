package com.example.demo.service;

import com.example.demo.pojo.Emp;
import com.example.demo.pojo.PageBean;
import org.apache.ibatis.annotations.Insert;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void add(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
