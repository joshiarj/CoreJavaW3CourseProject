/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.courseproject.entity;

/**
 *
 * @author Zeppelin
 */
public class Batch {

    private int id;
    private String code;
    private Course course;
    private boolean status;

    public Batch() {
    }

    public Batch(int id, String code, Course course, boolean status) {
        this.id = id;
        this.code = code;
        this.course = course;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Batch{" + "ID=" + id + ", Code=" + code + ", Status=" + status + '}';
    }
    
    
}
