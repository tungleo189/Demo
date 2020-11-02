package com.example.tungdthe130860_test2;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Course.class,Student.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract CourseDAO createCourseDAO();
    public abstract StudentDAO createStudentDAO();
}
