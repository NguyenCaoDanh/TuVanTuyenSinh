/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.service.impl;

import com.cloudinary.Cloudinary;
import com.tqh.pojo.Majors;
import com.tqh.repository.MajorRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class MajorServiceImpl implements com.tqh.service.MajorService {

    @Autowired
    private MajorRepository majorRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Majors> getMajors(Map<String, String> params) {
        return this.majorRepo.getMajors(params);
    }

    @Override
    public Long countMajors(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long countMajors() {
        return this.majorRepo.countMajors();
    }

    @Override
    public boolean addOrUpdateMajors(Majors p) {
        return this.majorRepo.addOrUpdateMajors(p);
    }

    @Override
    public Majors getMajorsById(int id) {
        return this.majorRepo.getMajorsById(id);
    }

    @Override
    public boolean deleteMajors(int id) {
       return this.majorRepo.deleteMajors(id);
    }

}
