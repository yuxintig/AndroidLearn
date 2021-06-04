package com.shinonon.course;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shinonon.course.java.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

        private TimetableView mTimetable;
        private CourseDao mCourseDao;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mCourseDao = new CourseDao(MainActivity.this);
            mTimetable = findViewById(R.id.timetable);

/*            List<CourseModel> list = getTestData();
            for(CourseModel course:list){
                mCourseDao.insert(course);
            }*/

            mTimetable.setOnCourseItemClickListener(new TimetableView.OnCourseItemClickListener() {
                @Override
                public void onCourseItemClick(View v,CourseModel course) {
                    PopupMenu popup = new PopupMenu(MainActivity.this, v);
                    popup.getMenuInflater()
                            .inflate(R.menu.action, popup.getMenu());
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            if (item.getItemId() == R.id.action_edit){
                                Intent intent = new Intent(MainActivity.this,EditActivity.class);
                                intent.putExtra("course",course);
                                startActivity(intent);
                            }else if(item.getItemId() == R.id.action_delete){
                                //todo 数据库删除记录
                                mCourseDao.delete(course);
                                Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                            }
                            return true;
                        }
                    });
                    popup.show();
                }
            });

            FloatingActionButton fabAdd = findViewById(R.id.fab_add);
            fabAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,EditActivity.class);
                    startActivity(intent);
                }
            });
        }

    @Override
    protected void onResume() {
        super.onResume();
        mTimetable.loadCourses(mCourseDao.selectAll());
    }

    private List<CourseModel> getTestData() {
            List<CourseModel> list = new ArrayList<>();

            CourseModel course1 = new CourseModel();
            course1.setCname("计算机网络");
            course1.setClassroom("1号楼103");
            course1.setStartSection(1);
            course1.setEndSection(4);
            course1.setDayOfWeek(1);
            course1.setStartWeek(1);
            course1.setEndWeek(12);
            list.add(course1);

            CourseModel course2 = new CourseModel();
            course2.setCname("计算机组成原理");
            course2.setClassroom("1号楼312");
            course2.setStartSection(7);
            course2.setEndSection(8);
            course2.setDayOfWeek(1);
            course2.setStartWeek(1);
            course2.setEndWeek(12);
            list.add(course2);


            CourseModel course3 = new CourseModel();
            course3.setCname("数据结构与算法");
            course3.setClassroom("1号楼201");
            course3.setStartSection(1);
            course3.setEndSection(2);
            course3.setDayOfWeek(2);
            course3.setStartWeek(4);
            course3.setEndWeek(18);
            list.add(course3);


            CourseModel course4 = new CourseModel();
            course4.setCname("高等数学");
            course4.setClassroom("3号楼602");
            course4.setStartSection(5);
            course4.setEndSection(6);
            course4.setDayOfWeek(2);
            course4.setStartWeek(1);
            course4.setEndWeek(12);
            list.add(course4);


            CourseModel course5 = new CourseModel();
            course5.setCname("离散数学");
            course5.setClassroom("1号楼311");
            course5.setStartSection(3);
            course5.setEndSection(4);
            course5.setDayOfWeek(3);
            course5.setStartWeek(1);
            course5.setEndWeek(12);
            list.add(course5);


            CourseModel course6 = new CourseModel();
            course6.setCname("无线网络技术");
            course6.setClassroom("1号楼210");
            course6.setStartSection(1);
            course6.setEndSection(2);
            course6.setDayOfWeek(4);
            course6.setStartWeek(4);
            course6.setEndWeek(8);
            list.add(course6);

            CourseModel course7 = new CourseModel();
            course7.setCname("大学体育");
            course7.setClassroom("运动场");
            course7.setStartSection(5);
            course7.setEndSection(6);
            course7.setDayOfWeek(4);
            course7.setStartWeek(4);
            course7.setEndWeek(12);
            list.add(course7);

            CourseModel course8 = new CourseModel();
            course8.setCname("操作系统");
            course8.setClassroom("2号楼303");
            course8.setStartSection(1);
            course8.setEndSection(4);
            course8.setDayOfWeek(5);
            course8.setStartWeek(1);
            course8.setEndWeek(12);
            list.add(course8);

            CourseModel course9 = new CourseModel();
            course9.setCname("Java语言程序设计");
            course9.setClassroom("2号楼104");
            course9.setStartSection(7);
            course9.setEndSection(8);
            course9.setDayOfWeek(5);
            course9.setStartWeek(1);
            course9.setEndWeek(12);
            list.add(course9);

            return list;
        }
    }