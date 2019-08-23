package com.jizheping.dao;

import com.jizheping.bean.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentDao extends CrudRepository<Student,Integer> {
    @Query(value = "select count(*) from student",nativeQuery = true)
    int getStudentCount();

    @Query(value = "select * from student limit ?1,?2",nativeQuery = true)
    List<Student> getStudent(int startPage, Integer rows);
}
