package com.example.demo.mapper;

import com.example.demo.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    @Insert("insert into emp(username,name,gender,image,job,entrydate,dept_id,create_time,update_time) \n" +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime});")
    void insert(Emp emp);

    @Select("select * from  emp where id=#{id}")
    Emp getById(Integer id);

    void update(Emp emp);

    @Select("select * from emp where username= #{username} and password=#{password}")
    Emp getByUsernameAndPassword(Emp emp);
}
