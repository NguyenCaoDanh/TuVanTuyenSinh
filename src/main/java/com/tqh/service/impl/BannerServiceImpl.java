/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tqh.pojo.Banner;
import com.tqh.repository.BannerRepository;
import com.tqh.service.BannerService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class BannerServiceImpl implements BannerService{
    @Autowired
    private BannerRepository bannerRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Banner> getBanners(Map<String, String> params) {
        return this.bannerRepo.getBanners(params); 
    }

    @Override
    public Long countBanner() {
        return this.bannerRepo.countBanner();
    }

    @Override
    public boolean addOrUpdateBanner(Banner b) {
        if (!b.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(b.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                b.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.bannerRepo.addOrUpdateBanner(b);
    }

    @Override
    public boolean deleteBanner(int id) {
                return this.bannerRepo.deleteBanner(id);
    }

    @Override
    public Banner getBannerById(int id) {
        return this.bannerRepo.getBannerById(id);
    }
    
    
}
