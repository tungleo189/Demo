package com.example.tungdthe130860_test2;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class CourseWithStudents  {
    @Embedded
    public Course catalog;


    @Relation(parentColumn = "courseId",
            entityColumn = "courseOwnerId")
    public List<Student> students;
}
