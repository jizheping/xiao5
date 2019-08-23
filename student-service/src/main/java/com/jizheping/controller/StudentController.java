package com.jizheping.controller;

import com.alibaba.fastjson.JSONObject;
import com.jizheping.bean.Student;
import com.jizheping.service.StudentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Value("${filePath}")
    private  String filePathImg;
    @Value("${fileDomain}")
    private  String fileDomain;

    @RequestMapping(value = "/getStudentList",method = RequestMethod.GET)
    public Map<String,Object> getStudentList(@RequestParam(defaultValue = "1") Integer cpage,@RequestParam(defaultValue = "3") Integer rows) throws ParseException {
        Map<String,Object> map = studentService.getStudentList(cpage,rows);

        return map;
    }

    @RequestMapping(value = "/savePic",method = RequestMethod.POST)
    public Object saveStudent(@RequestBody MultipartFile file){
        //获取上传文件的扩展名
        String fileName = file.getOriginalFilename();
        String extName = ".jpg";

        if(StringUtils.isNotBlank(fileName) && fileName.contains(".")){
            String name = fileName.substring(fileName.lastIndexOf("."), fileName.length());
            if(StringUtils.isNotBlank(name)){
                extName = name;
            }
        }

        //生成保存文件扩展名
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = simpleDateFormat.format(new Date());
        String saveFileName = dateStr + "_" + new Random().nextInt(1000) + extName;

        //创建文件夹
        File filePath = new File(filePathImg);
        if(!filePath.exists()){
            filePath.mkdirs();
        }

        //封装上传结果给前端
        Map<String,Object> map = new HashMap<>();
        map.put("flag",true);

        File dest = new File(filePathImg+saveFileName);

        try {
            file.getInputStream();

            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();

            map.put("flag",false);

            return map;
        }

        System.out.println(fileDomain+saveFileName);

        map.put("imgUrl",fileDomain+saveFileName);

        return map;
    }

    @RequestMapping("/addStudent")
    public boolean addStudent(@RequestBody String student){
        Map<String,JSONObject> map = JSONObject.parseObject(student, Map.class);
        JSONObject obj = map.get("student");
        Student stu = JSONObject.parseObject(obj.toJSONString(), Student.class);

        try {
            studentService.addStudent(stu);

            return true;
        }catch (Exception e){
            e.printStackTrace();

            return false;
        }
    }

    @RequestMapping("/deleteStudentById")
    public boolean deleteStudentById(Integer id){
        try {
            studentService.deleteStudentById(id);

            return true;
        }catch (Exception e){
            e.printStackTrace();

            return false;
        }
    }
}
