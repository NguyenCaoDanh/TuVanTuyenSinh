/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.repository;

import com.tqh.pojo.Majors;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public interface MajorRepository {
    List<Majors> getMajors(Map<String, String> params);
    Long countMajors(int id);
    Long countMajors();
    boolean addOrUpdateMajors(Majors p);
    Majors getMajorsById(int id);
    boolean deleteMajors(int id);
}
