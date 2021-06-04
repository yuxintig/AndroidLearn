package com.shinonon.sqlite.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.shinonon.sqlite.DBHelper;
import com.shinonon.sqlite.Student;

import java.util.ArrayList;
import java.util.List;


public class StudentDao {
    private DBHelper dbHelper;

    public StudentDao(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void insert(Student student) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", student.getName());
        values.put("classmate", student.getClassmate());
        values.put("age", student.getAge());
        db.insert("t_student", null, values);
        db.close();
    }

    public List<Student> selectAll() {
        List<Student> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("t_student", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String classmate = cursor.getString(cursor.getColumnIndex("classmate"));
            int age = cursor.getInt(cursor.getColumnIndex("age"));
            list.add(new Student(id, name, classmate, age));
        }
        cursor.close();
        db.close();
        return list;
    }

    public  void  update(Student student){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",student.getName());
        values.put("classmate",student.getClassmate());
        values.put("age" , student.getAge());

        db.update("t_student", values,"_id=?",new String[]{
                String.valueOf(student.getId())
        });
        db.close();
    }

    public  void  delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("t_student","_id=?",new String[]
                {String.valueOf(id)});
        db.close();
    }


}