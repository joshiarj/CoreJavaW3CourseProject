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
public class Enrollment {

    private int id;
    private Student student;
    private Batch batch;

    public Enrollment() {
    }

//    public Enrollment(int id, Student student, Batch batch) {
//        this.id = id;
//        this.student = student;
//        this.batch = batch;
//    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

}
