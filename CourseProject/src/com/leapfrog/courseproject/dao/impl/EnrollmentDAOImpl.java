/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.courseproject.dao.impl;

import com.leapfrog.courseproject.dao.EnrollmentDAO;
import com.leapfrog.courseproject.entity.Enrollment;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zeppelin
 */
public class EnrollmentDAOImpl implements EnrollmentDAO {

    private List<Enrollment> enrollmentList = new ArrayList<>();

    @Override
    public boolean insert(Enrollment e) {
        return enrollmentList.add(e);
    }

    @Override
    public boolean delete(int id) {
        Enrollment e = getById(id);
        if (e != null) {
            return enrollmentList.remove(e);
        }
        return false;
    }

    @Override
    public Enrollment getById(int id) {
        for (Enrollment e : enrollmentList) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Enrollment> getAll() {
        return enrollmentList;
    }

}
