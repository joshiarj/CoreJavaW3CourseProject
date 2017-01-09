/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.courseproject;

import com.leapfrog.courseproject.controller.BatchController;
import com.leapfrog.courseproject.controller.CourseController;
import com.leapfrog.courseproject.controller.EnrollmentController;
import com.leapfrog.courseproject.controller.StudentController;
import com.leapfrog.courseproject.dao.BatchDAO;
import com.leapfrog.courseproject.dao.CourseDAO;
import com.leapfrog.courseproject.dao.EnrollmentDAO;
import com.leapfrog.courseproject.dao.StudentDAO;
import com.leapfrog.courseproject.dao.impl.BatchDAOImpl;
import com.leapfrog.courseproject.dao.impl.CourseDAOImpl;
import com.leapfrog.courseproject.dao.impl.EnrollmentDAOImpl;
import com.leapfrog.courseproject.dao.impl.StudentDAOImpl;
import com.leapfrog.courseproject.entity.Course;
import java.util.Scanner;

/**
 *
 * @author Zeppelin
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        CourseDAO courseDAO = new CourseDAOImpl();
        StudentDAO studentDAO = new StudentDAOImpl();
        BatchDAO batchDAO = new BatchDAOImpl();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAOImpl();

        CourseController cc = new CourseController(courseDAO, input);
        BatchController bc = new BatchController(batchDAO, courseDAO, input);
        StudentController sc = new StudentController(studentDAO, batchDAO, courseDAO, input);
        EnrollmentController ec = new EnrollmentController(studentDAO, courseDAO, input);

        while (true) {
            System.out.println("\n1. Course");
            System.out.println("2. Student");
            System.out.println("3. Batch");
            System.out.println("4. Enrollment");
            System.out.println("5. Exit");
            System.out.println("Enter your choice [1-5]:");
            switch (input.nextInt()) {
                case 1:
                    cc.process();
                    break;
                case 2:
                    sc.process();
                    break;
                case 3:
                    bc.process();
                    break;
                case 4:
                    ec.process();
                    break;
                case 5:
                    System.out.println("Do you really want to exit [Y/N]?");
                    if (input.next().equalsIgnoreCase("Y")) {
                        System.exit(0);
                    }
                    break;
            }
        }
    }
}
