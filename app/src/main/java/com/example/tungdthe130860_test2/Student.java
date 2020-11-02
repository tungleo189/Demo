package com.example.tungdthe130860_test2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @PrimaryKey(autoGenerate = true)
    private long studentId;
    @ColumnInfo
    private String studentRoll;
    @ColumnInfo
    private String studentName;
    @ColumnInfo
    private String studentPhone;
    @ColumnInfo
    private String studentEmail;
    @ForeignKey(entity = Course.class,parentColumns = {"courseId"},childColumns = {"courseOwnerId"},onDelete = ForeignKey.CASCADE)
    private long courseOwnerId;

    public Student() {
    }

    public Student(String studentRoll, String studentName, String studentPhone, String studentEmail, long courseOwnerId) {
        this.studentRoll = studentRoll;
        this.studentName = studentName;
        this.studentPhone = studentPhone;
        this.studentEmail = studentEmail;
        this.courseOwnerId = courseOwnerId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentRoll() {
        return studentRoll;
    }

    public void setStudentRoll(String studentRoll) {
        this.studentRoll = studentRoll;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public long getCourseOwnerId() {
        return courseOwnerId;
    }

    public void setCourseOwnerId(long courseOwnerId) {
        this.courseOwnerId = courseOwnerId;
    }

    @Override
    public String toString() {
        return studentName;
    }
}
