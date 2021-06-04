package com.shinonon.course;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Finger
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String CREATE_TABLE_COURSEMODEL = "CREATE TABLE CourseModel (" +
            "  cid INTEGER PRIMARY KEY AUTOINCREMENT," +
            "  cname TEXT NOT NULL," +
            "  startSection INTEGER NOT NULL," +
            "  endSection INTEGER NOT NULL," +
            "  startWeek INTEGER NOT NULL," +
            "  endWeek INTEGER NOT NULL," +
            "  dayOfWeek INTEGER NOT NULL," +
            "  classroom TEXT," +
            "  teacher TEXT" +
            ");";

    public DbHelper(Context context) {
        super(context, "course-db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbHelper.CREATE_TABLE_COURSEMODEL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
