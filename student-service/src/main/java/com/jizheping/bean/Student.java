package com.jizheping.bean;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private Date birthday;
    private Integer shengId;
    private Integer shiId;
    private Integer xianId;
    @Transient
    private String shengName;
    @Transient
    private String shiName;
    @Transient
    private String xianName;
    private Integer cid;
    @Transient
    private String cname;
    private String url;

    @Transient
    private List<Integer> pid;

    @ManyToMany
    @JoinTable(name = "studentHobbyMiddle",joinColumns = @JoinColumn(name = "sid"),inverseJoinColumns = @JoinColumn(name = "hid"))
    private List<Hobby> hobbys;

    @Transient
    private String hids;

    @Transient
    private String hobbyNames;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", shengId=" + shengId +
                ", shiId=" + shiId +
                ", xianId=" + xianId +
                ", shengName='" + shengName + '\'' +
                ", shiName='" + shiName + '\'' +
                ", xianName='" + xianName + '\'' +
                ", cid=" + cid +
                ", cname='" + cname + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                ", hobbys=" + hobbys +
                ", hids='" + hids + '\'' +
                ", hobbyNames='" + hobbyNames + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getShengId() {
        return shengId;
    }

    public void setShengId(Integer shengId) {
        this.shengId = shengId;
    }

    public Integer getShiId() {
        return shiId;
    }

    public void setShiId(Integer shiId) {
        this.shiId = shiId;
    }

    public Integer getXianId() {
        return xianId;
    }

    public void setXianId(Integer xianId) {
        this.xianId = xianId;
    }

    public String getShengName() {
        return shengName;
    }

    public void setShengName(String shengName) {
        this.shengName = shengName;
    }

    public String getShiName() {
        return shiName;
    }

    public void setShiName(String shiName) {
        this.shiName = shiName;
    }

    public String getXianName() {
        return xianName;
    }

    public void setXianName(String xianName) {
        this.xianName = xianName;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Integer> getPid() {
        return pid;
    }

    public void setPid(List<Integer> pid) {
        this.pid = pid;
    }

    public List<Hobby> getHobbys() {
        return hobbys;
    }

    public void setHobbys(List<Hobby> hobbys) {
        this.hobbys = hobbys;
    }

    public String getHids() {
        return hids;
    }

    public void setHids(String hids) {
        this.hids = hids;
    }

    public String getHobbyNames() {
        return hobbyNames;
    }

    public void setHobbyNames(String hobbyNames) {
        this.hobbyNames = hobbyNames;
    }

    public Student() {
    }

    public Student(String name, String sex, Integer age, Date birthday, Integer shengId, Integer shiId, Integer xianId, String shengName, String shiName, String xianName, Integer cid, String cname, String url, List<Integer> pid, List<Hobby> hobbys, String hids, String hobbyNames) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
        this.shengId = shengId;
        this.shiId = shiId;
        this.xianId = xianId;
        this.shengName = shengName;
        this.shiName = shiName;
        this.xianName = xianName;
        this.cid = cid;
        this.cname = cname;
        this.url = url;
        this.pid = pid;
        this.hobbys = hobbys;
        this.hids = hids;
        this.hobbyNames = hobbyNames;
    }
}
