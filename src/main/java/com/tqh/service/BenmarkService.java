/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.service;

import com.tqh.pojo.Benmarks;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public interface BenmarkService {
    List<Benmarks> getBenMarks(Map<String, String> params);
    Long countBenmarks();
    boolean addOrUpdateBenmarks(Benmarks p);
    Benmarks getBenmarksById(int id);
    boolean deleteBenmarks(int id);
}
