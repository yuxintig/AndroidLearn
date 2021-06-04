package com.shinonon.course;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Finger
 */
public class CourseDao {
    private final DbHelper dbHelper;
    private SQLiteDatabase db;

    public CourseDao(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void insert(CourseModel courseModel) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cname", courseModel.getCname());
        values.put("startSection", courseModel.getStartSection());
        values.put("endSection", courseModel.getEndSection());
        values.put("startWeek", courseModel.getStartWeek());
        values.put("endWeek", courseModel.getEndWeek());
        values.put("dayOfWeek", courseModel.getDayOfWeek());
        values.put("classroom", courseModel.getClassroom());
        values.put("teacher", courseModel.getTeacher());
        db.insert("CourseModel", null, values);
        db.close();
    }

    public List<CourseModel> selectAll() {
        List<CourseModel> list = new ArrayList<>();
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("CourseModel", null, null, null, null, null, "cid");
        while (cursor.moveToNext()) {
            long cid = cursor.getLong(cursor.getColumnIndex("cid"));
            String cname = cursor.getString(cursor.getColumnIndex("cname"));
            int startSection = cursor.getInt(cursor.getColumnIndex("startSection"));
            int endSection = cursor.getInt(cursor.getColumnIndex("endSection"));
            int startWeek = cursor.getInt(cursor.getColumnIndex("startWeek"));
            int endWeek = cursor.getInt(cursor.getColumnIndex("endWeek"));
            int dayOfWeek = cursor.getInt(cursor.getColumnIndex("dayOfWeek"));
            String classroom = cursor.getString(cursor.getColumnIndex("classroom"));
            String teacher = cursor.getString(cursor.getColumnIndex("teacher"));
            list.add(new CourseModel(cid,cname,startSection,endSection,startWeek,endWeek,dayOfWeek,classroom,teacher));
        }
        cursor.close();
        return list;
    }

    public void update(CourseModel courseModel) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cid", courseModel.getCid());
        values.put("cname", courseModel.getCname());
        values.put("startSection", courseModel.getStartSection());
        values.put("endSection", courseModel.getEndSection());
        values.put("startWeek", courseModel.getStartWeek());
        values.put("endWeek", courseModel.getEndWeek());
        values.put("dayOfWeek", courseModel.getDayOfWeek());
        values.put("classroom", courseModel.getClassroom());
        values.put("teacher", courseModel.getTeacher());
        db.update("CourseModel", values,"cid = ?",new String[]{String.valueOf(courseModel.getCid())});
        db.close();
    }

    public void delete(CourseModel course) {
        //todo 删除的sql操作
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("CourseModel","cid=?",new String[]
                {String.valueOf(course.getCid())});
        db.close();
    }
}