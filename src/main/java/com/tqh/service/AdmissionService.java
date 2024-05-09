/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tqh.service;

import com.tqh.pojo.Admission;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface AdmissionService {

    List<Admission> getAdmissions();

    List<Admission> getAdmissions(Map<String, String> params);

    Admission getAdmissionById(int id);
}
