/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.courseproject.dao;

import java.util.List;

/**
 *
 * @author Zeppelin
 */
public interface GenericDAO<T> {

    boolean insert(T c);

    boolean delete(int id);

    T getById(int id);

    List<T> getAll();
}
