package com.shinonon.course;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shinonon.course.java.databinding.ActivityEditBinding;
import com.shinonon.framework.base.BaseActivity;


public class EditActivity extends BaseActivity<ActivityEditBinding> {

    CourseDao mCourseDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        CourseModel course = (CourseModel) intent.getSerializableExtra("course");
        if(course!=null){
            //编辑模式

            v.edCname.setText(course.getCname());
            v.edStartSection.setText(String.valueOf(course.getStartSection()));
            v.edEndSection.setText(String.valueOf(course.getEndSection()));
            v.edStartWeek.setText(String.valueOf(course.getStartWeek()));
            v.edEndWeek.setText(String.valueOf(course.getEndWeek()));
            v.edDayOfWeek.setText(String.valueOf(course.getDayOfWeek()));
            v.edClassroom.setText(course.getClassroom());
            v.edTeacher.setText(course.getTeacher());
            v.btn.setText("修改课程");
        }
        mCourseDao = new CourseDao(EditActivity.this);
        v.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CourseModel courseModel = new CourseModel();
                courseModel.setCname(v.edCname.getText().toString());
                courseModel.setStartSection(Integer.parseInt(v.edStartSection.getText().toString()));
                courseModel.setEndSection(Integer.parseInt(v.edEndSection.getText().toString()));
                courseModel.setStartWeek(Integer.parseInt(v.edStartWeek.getText().toString()));
                courseModel.setEndWeek(Integer.parseInt(v.edEndWeek.getText().toString()));
                courseModel.setDayOfWeek(Integer.parseInt(v.edDayOfWeek.getText().toString()));
                courseModel.setTeacher(v.edTeacher.getText().toString());
                courseModel.setClassroom(v.edClassroom.getText().toString());
                if (course!=null){
                    courseModel.setCid(course.getCid());
                    mCourseDao.update(courseModel);
                }else{
                    mCourseDao.insert(courseModel);
                }
                finishself();
            }
        });
    }
}