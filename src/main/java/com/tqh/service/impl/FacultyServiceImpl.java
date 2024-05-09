/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tqh.pojo.Faculty;
import com.tqh.repository.FacultyRepository;
import com.tqh.service.FacultyService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public Faculty getFacultyById(int id) {
        return this.facultyRepo.getFacultyById(id);
    }

    @Override
    public List<Faculty> getFalcuties(Map<String, String> params) {
        return this.facultyRepo.getFalcuties(params);
    }

    @Override
    public Long countFaculty() {
        return this.facultyRepo.countFaculty();
    }

    @Override
    public boolean addOrUpdateFaculty(Faculty f) {
        if (!f.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(f.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                f.setIntrovideo(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.facultyRepo.addOrUpdateFaculty(f);
    }

    @Override
    public boolean deleteFalcuty(int id) {
        return this.facultyRepo.deleteFalcuty(id);
    }

    @Override
    public List<Faculty> getFalcuties() {
        return this.facultyRepo.getFalcuties();
    }

}
