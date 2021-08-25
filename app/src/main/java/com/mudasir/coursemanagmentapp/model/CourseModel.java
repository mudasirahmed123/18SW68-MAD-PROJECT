package com.mudasir.coursemanagmentapp.model;
public class CourseModel {

    // variables for our coursename,
    // description, tracks and duration, id.
    private String courseName;
    private String courseDuration;
    private String courseTeacher;
    private String courseDescription;
    private int id;

    // creating getter and setter methods
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTracks(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public CourseModel(String courseName, String courseDuration, String courseTeacher, String courseDescription) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.courseTeacher = courseTeacher;
        this.courseDescription = courseDescription;
    }
}

