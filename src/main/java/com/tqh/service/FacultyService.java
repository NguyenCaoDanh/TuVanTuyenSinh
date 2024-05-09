/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.service;

import com.tqh.pojo.Faculty;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public interface  FacultyService {
     List<Faculty> getFalcuties();
    
    List<Faculty> getFalcuties(Map<String, String> params);

    Faculty getFacultyById(int id);

    Long countFaculty();

    boolean addOrUpdateFaculty(Faculty f);

    boolean deleteFalcuty(int id);
}
