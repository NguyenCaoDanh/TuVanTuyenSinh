/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.pojo.Livestreams;
import com.tqh.service.AdmissionService;
import com.tqh.service.CommentService;
import com.tqh.service.FacultyService;
import com.tqh.service.LivestreamService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/api")
public class ApiLivestreamController {

    @Autowired
    private LivestreamService livestreamService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private AdmissionService admissionService;
    @Autowired
    private CommentService commentService;
    
    @DeleteMapping("/livestreams/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.livestreamService.deleteLivestreams(id);
    }
    
    @RequestMapping("/livestreams/")
    @CrossOrigin
    public ResponseEntity<List<Livestreams>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.livestreamService.getLiveStreams(params), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/livestreams/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Livestreams> details2(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.livestreamService.getLivestreamsById(id), HttpStatus.OK );
    }
    
    @PostMapping(path = "/livestreams", consumes = {
        MediaType.MULTIPART_FORM_DATA_VALUE,
        MediaType.APPLICATION_JSON_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestParam Map<String, String> params, MultipartFile[] file) {
        Livestreams p = new Livestreams();
        p.setTitle(params.get("name"));
        p.setLivestreaminfomation(params.get("information"));
        p.setPicture(params.get("image"));
        if (file.length > 0) {
            p.setFile(file[0]);
        }
        this.livestreamService.addOrUpdateLivestreams(p);
    }
}
