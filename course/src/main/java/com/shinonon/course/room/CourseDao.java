package com.shinonon.course.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.shinonon.course.CourseModel;

import java.util.List;

@Dao
public interface CourseDao {
    @Insert
    void insert(CourseModel course);

    @Delete
    void delete(CourseModel course);

    @Update
    void update(CourseModel course);

    @Query("SELECT * from CourseModel")
    List<CourseModel> selectAll();
}
