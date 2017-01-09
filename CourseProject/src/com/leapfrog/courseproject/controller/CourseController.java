/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.courseproject.controller;

import com.leapfrog.courseproject.dao.CourseDAO;
import com.leapfrog.courseproject.entity.Course;
import java.util.Scanner;

/**
 *
 * @author Zeppelin
 */
public class CourseController {

    private CourseDAO courseDAO;
    private Scanner input;

    public CourseController(CourseDAO courseDAO, Scanner input) {
        this.courseDAO = courseDAO;
        this.input = input;
    }

    private void menu() {
        System.out.println("\n1. Add Course.");
        System.out.println("2. Delete Course.");
        System.out.println("3. Search by Id.");
        System.out.println("4. Show All Courses.");
        System.out.println("5. Back.");
    }

    private int generateId() {
        int count = courseDAO.getAll().size();
        if (count == 0) {
            return 1;
        }
        return courseDAO.getAll().get(count - 1).getId() + 1;
    }

    private void add() {
        Course course = new Course();
        course.setId(generateId());
        System.out.println("Enter Course Name:");
        course.setName(input.next());
        System.out.println("Enter Course Code:");
        course.setCode(input.next());
        System.out.println("Enter Course Fees:");
        course.setFees(input.nextInt());
        System.out.println("Enter Course Status [true/false]:");
        course.setStatus(input.nextBoolean());

        courseDAO.insert(course);
    }

    private void delete() {

    }

    private boolean searchById() {
        System.out.println("Enter Course ID to Search:");
        int searchId = input.nextInt();
        for (Course c : courseDAO.getAll()) {
            if (searchId == c.getId()) {
                System.out.println("Match found: \n" + c);
                return true;
            }
        }
        System.out.println("No Matching Course!");
        return false;
    }

    private void showAll() {
        System.out.println("Showing all courses:");
        for (Course c : courseDAO.getAll()) {
            System.out.println(c);
        }
    }

    public void process() {
        while (true) {
            boolean back = false;
            menu();
            System.out.println("Enter your choice [1-5]:");
            switch (input.nextInt()) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    searchById();
                    break;
                case 4:
                    showAll();
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
