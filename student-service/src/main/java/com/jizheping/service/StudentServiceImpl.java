package com.jizheping.service;

import com.jizheping.bean.City;
import com.jizheping.bean.Clazz;
import com.jizheping.bean.Hobby;
import com.jizheping.bean.Student;
import com.jizheping.cityFeign.CityFeign;
import com.jizheping.clazzFeign.ClazzFeign;
import com.jizheping.dao.StudentDao;
import com.jizheping.hobbyFeign.HobbyFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.ssl.HandshakeMessage;

import java.text.ParseException;
import java.util.*;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentDao studentDao;

    private final CityFeign cityFeign;

    private final ClazzFeign clazzFeign;

    private final HobbyFeign hobbyFeign;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao, CityFeign cityFeign, ClazzFeign clazzFeign, HobbyFeign hobbyFeign) {
        this.studentDao = studentDao;
        this.cityFeign = cityFeign;
        this.clazzFeign = clazzFeign;
        this.hobbyFeign = hobbyFeign;
    }


    @Override
    public Map<String, Object> getStudentList(Integer cpage, Integer rows) throws ParseException {
        int count = studentDao.getStudentCount();

        int pageSize = count%rows==0?count/rows:count/rows+1;

        int startPage = (cpage-1) * rows;

        List<Student> studentList = studentDao.getStudent(startPage,rows);

        List<Integer> ids = new ArrayList<>();

        List<Hobby> hobbyList = hobbyFeign.getHobbyList();

        for(Student student : studentList){
            ids.add(student.getShengId());
            ids.add(student.getShiId());
            ids.add(student.getXianId());

            String hobbyNames = "";
            String hids = "";

            for(Hobby hobby : student.getHobbys()){
                hobbyNames += "," + hobby.getName();
                hids += "," + hobby.getId();
            }

            hids = hids.substring(1);
            hobbyNames = hobbyNames.substring(1);

            student.setHobbyNames(hobbyNames.toString());
            student.setHids(hids.toString());
        }

        List<City> cityList = cityFeign.getCityListByIds(ids);

        for(Student student : studentList){
            for(City city : cityList){
                if(student.getShengId().equals(city.getId())){
                    student.setShengName(city.getCityname());

                    continue;
                }

                if(student.getShiId().equals(city.getId())){
                    student.setShiName(city.getCityname());

                    continue;
                }

                if(student.getXianId().equals(city.getId())){
                    student.setXianName(city.getCityname());
                }
            }
        }

        List<Clazz> clazzList = clazzFeign.getClazzList();

        for(Student student : studentList){
            for(Clazz clazz : clazzList){
                if(student.getCid().equals(clazz.getId())){
                    student.setCname(clazz.getName());

                    break;
                }
            }
        }

        Map<String,Object> map = new HashMap<>();

        map.put("studentList", studentList);
        map.put("cpage",cpage);
        map.put("pages",pageSize);

        return map;
    }

    @Override
    public void addStudent(Student stu) {
        studentDao.save(stu);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentDao.deleteById(id);
    }
}
