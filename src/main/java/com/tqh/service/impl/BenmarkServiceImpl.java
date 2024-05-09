/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.service.impl;

import com.cloudinary.Cloudinary;
import com.tqh.pojo.Benmarks;
import com.tqh.repository.BenmarkRepository;
import com.tqh.service.BenmarkService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class BenmarkServiceImpl implements BenmarkService{
  @Autowired
    private BenmarkRepository benmarkRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Benmarks> getBenMarks(Map<String, String> params) {
       return this.benmarkRepo.getBenMarks(params);
    }

    @Override
    public Long countBenmarks() {
      return this.benmarkRepo.countBenmarks();
    }

    @Override
    public boolean addOrUpdateBenmarks(Benmarks p) {
        return this.benmarkRepo.addOrUpdateBenmarks(p);
    }

    @Override
    public Benmarks getBenmarksById(int id) {
       return this.benmarkRepo.getBenmarksById(id);
    }

    @Override
    public boolean deleteBenmarks(int id) {
       return this.benmarkRepo.deleteBenmarks(id);
    }
    
}
