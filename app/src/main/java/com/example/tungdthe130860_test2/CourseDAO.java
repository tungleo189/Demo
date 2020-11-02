package com.example.tungdthe130860_test2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CourseDAO {
    @Transaction
    @Insert
    public long insert(Course course);

    @Update
    public void update(Course course);

    @Delete
    public void delete(Course course);

    @Query("SELECT * FROM course")
    public List<Course> getCourses();

    @Query("SELECT * FROM course")
    public List<CourseWithStudents> getCourseWithStudents();
}
