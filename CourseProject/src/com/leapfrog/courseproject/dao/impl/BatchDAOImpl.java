/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.courseproject.dao.impl;

import com.leapfrog.courseproject.dao.BatchDAO;
import com.leapfrog.courseproject.entity.Batch;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zeppelin
 */
public class BatchDAOImpl implements BatchDAO {

    private List<Batch> batchList = new ArrayList<>();

    @Override
    public boolean insert(Batch b) {
        return batchList.add(b);
    }

    @Override
    public boolean delete(int id) {
        Batch b = getById(id);
        if (b != null) {
            return batchList.remove(b);
        }
        return false;
    }

    @Override
    public Batch getById(int id) {
        for (Batch b : batchList) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    @Override
    public List<Batch> getAll() {
        return batchList;
    }

}
