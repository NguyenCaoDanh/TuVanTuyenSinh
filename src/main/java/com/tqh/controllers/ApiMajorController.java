/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.pojo.Majors;
import com.tqh.service.MajorService;
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

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/api")
public class ApiMajorController {

    @Autowired
    private MajorService majorService;

    @DeleteMapping("/major/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.majorService.deleteMajors(id);
    }

    @RequestMapping("/major/")
    @CrossOrigin
    public ResponseEntity<java.util.List<Majors>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.majorService.getMajors(params), HttpStatus.OK);
    }

    @PostMapping(path = "/major", consumes = {
        MediaType.MULTIPART_FORM_DATA_VALUE,
        MediaType.APPLICATION_JSON_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestParam Map<String, String> params) {
        Majors f = new Majors();
        f.getMajorname();
        f.getBenmarksSet();

        this.majorService.addOrUpdateMajors(f);
    }
}
