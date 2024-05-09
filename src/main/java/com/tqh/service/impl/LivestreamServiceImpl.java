/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tqh.pojo.Livestreams;
import com.tqh.repository.LivestreamRepository;
import com.tqh.service.LivestreamService;
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
public class LivestreamServiceImpl implements LivestreamService {

    @Autowired
    private LivestreamRepository livestreamRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Livestreams> getLiveStreams(Map<String, String> params) {
      return this.livestreamRepo.getLiveStreams(params);
    }

    @Override
    public List<Livestreams> getLivestreamsByAdmission(Map<String, String> params, int id) {
         return this.livestreamRepo.getLivestreamsByAdmission(params, id);
    }

    @Override
    public Long countLivestreams(int id) {
         return this.livestreamRepo.countLivestreams(id);
    }

    @Override
    public Long countLivestreams() {
        return this.livestreamRepo.countLivestreams();
    }

    @Override
    public boolean addOrUpdateLivestreams(Livestreams p) {
        if (!p.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(p.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                p.setPicture(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         return this.livestreamRepo.addOrUpdateLivestreams(p);
    }

    @Override
    public Livestreams getLivestreamsById(int id) {
         return this.livestreamRepo.getLivestreamsById(id);
    }

    @Override
    public boolean deleteLivestreams(int id) {
         return this.livestreamRepo.deleteLivestreams(id);
    }

}
