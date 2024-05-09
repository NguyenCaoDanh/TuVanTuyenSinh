/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.pojo.Faculty;
import com.tqh.service.FacultyService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
public class ApiFacultyController {

    @Autowired
    private FacultyService facultyService;

    @DeleteMapping("/faculties/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.facultyService.deleteFalcuty(id);
    }

    
    @GetMapping("/faculties/")
    @CrossOrigin
    public ResponseEntity<List<Faculty>> list() {
        return new ResponseEntity<>(this.facultyService.getFalcuties(), HttpStatus.OK);
    }
    
    @RequestMapping("/faculties/")
    @CrossOrigin
    public ResponseEntity<List<Faculty>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.facultyService.getFalcuties(params), HttpStatus.OK);
    }

    @RequestMapping(path = "/faculties/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Faculty> details1(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.facultyService.getFacultyById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/faculties", consumes = {
        MediaType.MULTIPART_FORM_DATA_VALUE,
        MediaType.APPLICATION_JSON_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file) {
        Faculty f = new Faculty();
        f.getFacultyname();
        f.getWebsite();
        f.getIntrovideo();
        if (file.length > 0) {
            f.setFile(file[0]);
        }
        this.facultyService.addOrUpdateFaculty(f);
    }
}
