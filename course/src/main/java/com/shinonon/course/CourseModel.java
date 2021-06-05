package com.shinonon.course;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class CourseModel implements Serializable {
    @PrimaryKey
    private long cid;         //课程 id
    private String cname;       //课程名
    private int startSection;   //开始节次
    private int endSection;     //结束节次
    private int startWeek;      //开始周次
    private int endWeek;        //结束周次
    private int dayOfWeek;      //周几
    private String classroom;   //教室
    private String teacher;     //教师

    public CourseModel(){}
}