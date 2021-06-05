package com.shinonon.course.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.shinonon.course.CourseModel;

@Database(entities = {CourseModel.class}, version = 1, exportSchema = false)
    public abstract class CourseDatabase extends RoomDatabase {
        private static CourseDatabase instance;

        public abstract CourseDao courseDao();

        public static synchronized CourseDatabase getInstance(Context context) {
            if (instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(), CourseDatabase.class, "course-db")
                        .fallbackToDestructiveMigration()
                        .build();
            }
            return instance;
        }
    }
