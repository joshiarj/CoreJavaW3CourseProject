/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.courseproject.controller;

import com.leapfrog.courseproject.dao.BatchDAO;
import com.leapfrog.courseproject.dao.CourseDAO;
import com.leapfrog.courseproject.dao.StudentDAO;
import com.leapfrog.courseproject.dao.impl.StudentDAOImpl;
import com.leapfrog.courseproject.entity.Batch;
import com.leapfrog.courseproject.entity.Course;
import com.leapfrog.courseproject.entity.Student;
import java.util.Scanner;

/**
 *
 * @author Zeppelin
 */
public class StudentController {

    private StudentDAO studentDAO;
    private BatchDAO batchDAO;
    private CourseDAO courseDAO;
    private Scanner input;

    public StudentController(StudentDAO studentDAO, BatchDAO batchDAO, CourseDAO courseDAO, Scanner input) {
        this.studentDAO = studentDAO;
        this.batchDAO = batchDAO;
        this.courseDAO = courseDAO;
        this.input = input;
    }

    private void menu() {
        System.out.println("\n1. Add New Student.");
        System.out.println("2. Delete existing student.");
        System.out.println("3. Show All Students.");
        System.out.println("4. Search Student by Id.");
        System.out.println("5. Back.");
    }

    private int generateId() {
        int count = studentDAO.getAll().size();
        if (count == 0) {
            return 1;
        }
        return studentDAO.getAll().get(count - 1).getId() + 1;
    }

    private void add() {
        Student student = new Student();
        student.setId(generateId());
        System.out.println("Enter First Name:");
        student.setFirstName(input.next());
        System.out.println("Enter Last Name:");
        student.setLastName(input.next());
        System.out.println("Enter Student Status [true/false]:");
        student.setStatus(input.nextBoolean());
//        String fullName = student.getFirstName() + " " + student.getLastName();
//        System.out.println(fullName);

        studentDAO.insert(student);
    }

    private void delete() {
        System.out.println("Enter ID of student to delete:");
        int idToDelete = input.nextInt();
        for (Student s : studentDAO.getAll()) {
            if (idToDelete == s.getId()) {
                System.out.println("Delete this student? [Y/N]\n" + s);
                if (input.next().equalsIgnoreCase("y")) {
//                    if (s.isStatus() == false) {
                    studentDAO.delete(s.getId());
//                    } else {
//                        System.out.println("Cannot delete this student! Status is true.");
//                    }
                }
            }
            if (s.getId() > idToDelete) {
                s.setId(s.getId() - 1);
            }
            System.out.println(s);
        }
    }

    private boolean searchById() {
        System.out.println("Enter Student ID to Search:");
        int searchId = input.nextInt();
        for (Student s : studentDAO.getAll()) {
            if (searchId == s.getId()) {
                System.out.println("Match found: \n" + s);
                return true;
            }
        }
        System.out.println("No Match!");
        return false;
    }

    private void showAll() {
        System.out.println("Showing all students:");
        for (Student s : studentDAO.getAll()) {
            System.out.println(s);
        }
    }

    public void process() {
        while (true) {
            boolean back = false;
            menu();
            System.out.println("Enter your choice [1-4]:");
            switch (input.nextInt()) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    showAll();
                    break;
                case 4:
                    searchById();
                    break;
                case 5:
                    back = true;
                    break;
            }
            if (back) {
                break;
            }
        }
    }

}
