/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.courseproject.controller;

import com.leapfrog.courseproject.dao.CourseDAO;
import com.leapfrog.courseproject.dao.StudentDAO;
import com.leapfrog.courseproject.entity.Course;
import com.leapfrog.courseproject.entity.Student;
import java.util.Scanner;

/**
 *
 * @author Zeppelin
 */
public class EnrollmentController {

    private StudentDAO studentDAO;
    private CourseDAO courseDAO;
    private Scanner input;

    public EnrollmentController(StudentDAO studentDAO, CourseDAO courseDAO, Scanner input) {
        this.studentDAO = studentDAO;
        this.courseDAO = courseDAO;
        this.input = input;
    }

    public void process() {

    }

}
