/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.service;

import com.tqh.pojo.School;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public interface SchoolService {
     List<School> getSchool(Map<String, String> params);
    Long countSchool();
    boolean addOrUpdateSChool(School b);
    boolean deleteSchool(int id);
    School getSchoolById(int id);
}
