package com.jizheping.bean;

import javax.persistence.*;

/**
 * 学生与爱好中间表
 */

@Entity
@Table(name = "studentHobbyMiddle")
public class StudentHobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer sid;
    private Integer hid;

    @Override
    public String toString() {
        return "StudentHobby{" +
                "id=" + id +
                ", sid=" + sid +
                ", hid=" + hid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public StudentHobby() {
    }

    public StudentHobby(Integer sid, Integer hid) {
        this.sid = sid;
        this.hid = hid;
    }
}
