/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.pojo.Banner;
import com.tqh.pojo.Users;
import com.tqh.service.BannerService;
import com.tqh.service.UserService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/api")
public class ApiBannerController {

    @Autowired
    private BannerService bannerService;
    @Autowired
    private UserService userService;
    @DeleteMapping("/banners/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.bannerService.deleteBanner(id);
    }

    @RequestMapping("/banners/")
    @CrossOrigin
    public ResponseEntity<List<Banner>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.bannerService.getBanners(params), HttpStatus.OK);
    }

    @PostMapping(path = "/banners", consumes = {
        MediaType.MULTIPART_FORM_DATA_VALUE,
        MediaType.APPLICATION_JSON_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file) {
        Banner p = new Banner();
        p.setImage(params.get("image"));
        if (file.length > 0) {
            p.setFile(file[0]);
        }
        this.bannerService.addOrUpdateBanner(p);
    }
}
