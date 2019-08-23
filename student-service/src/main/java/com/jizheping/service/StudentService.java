package com.jizheping.service;

import com.jizheping.bean.Student;

import java.text.ParseException;
import java.util.Map;

public interface StudentService {
    Map<String, Object> getStudentList(Integer cpage, Integer rows) throws ParseException;

    void addStudent(Student stu);

    void deleteStudentById(Integer id);
}
