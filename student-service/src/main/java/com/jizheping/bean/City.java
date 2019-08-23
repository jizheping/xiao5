package com.jizheping.bean;

import sun.awt.SunHints;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cityname;
    private Integer pid;
    private Integer type;

    public City() {
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityname='" + cityname + '\'' +
                ", pid=" + pid +
                ", type=" + type +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public City(String cityname, Integer pid, Integer type) {
        this.cityname = cityname;
        this.pid = pid;
        this.type = type;
    }
}
