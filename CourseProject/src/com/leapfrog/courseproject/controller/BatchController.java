/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.courseproject.controller;

import com.leapfrog.courseproject.dao.BatchDAO;
import com.leapfrog.courseproject.entity.Batch;
import com.leapfrog.courseproject.dao.CourseDAO;
import com.leapfrog.courseproject.entity.Course;
import java.util.Scanner;

/**
 *
 * @author Zeppelin
 */
public class BatchController {

    private BatchDAO batchDAO;
    private CourseDAO courseDAO;
    private Scanner input;

    public BatchController(BatchDAO batchDAO, CourseDAO courseDAO, Scanner input) {
        this.batchDAO = batchDAO;
        this.courseDAO = courseDAO;
        this.input = input;
    }

    private int generateId() {
        int count = batchDAO.getAll().size();
        if (count == 0) {
            return 1;
        }
        return batchDAO.getAll().get(count - 1).getId() + 1;
    }

    private String generateCode(int chosenId, Course course) {

        return course.getCode() + "-" + generateId();
    }

    private void menu() {
        System.out.println("\n1. Add New Batch.");
        System.out.println("2. Delete Batch.");
        System.out.println("3. Show All Batches.");
        System.out.println("4. Back.");
    }

    private void add() {
        System.out.println("Enter id of the course you want to create batch in. Available courses are:");
        for (Course c : courseDAO.getAll()) {
            if (c.isStatus() == true) {
                System.out.println(c);
            }
        }
        int chosenCourseId = input.nextInt();

        Batch b = new Batch();
        for (Course c : courseDAO.getAll()) {
            if (c.getId() == chosenCourseId) {
                b.setId(generateId());
                b.setCode(generateCode(chosenCourseId, c));
            }
        }
    }

    private void delete() {

    }

    private void showAll() {
        System.out.println("Showing all batches:");
        for (Batch b : batchDAO.getAll()) {
            System.out.println(b);
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
                    back = true;
                    break;
            }
            if (back) {
                break;
            }

        }
    }

}
