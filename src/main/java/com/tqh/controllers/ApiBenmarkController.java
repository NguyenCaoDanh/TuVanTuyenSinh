/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.pojo.Benmarks;
import com.tqh.pojo.Faculty;
import com.tqh.service.BenmarkService;
import com.tqh.service.FacultyService;
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
public class ApiBenmarkController {

    @Autowired
    private BenmarkService benmarkService;
    @Autowired
    private FacultyService facultyService;

    @DeleteMapping("/benmarks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.benmarkService.deleteBenmarks(id);
    }

    @RequestMapping("/benmarks/")
    @CrossOrigin
    public ResponseEntity<List<Benmarks>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.benmarkService.getBenMarks(params), HttpStatus.OK);
    }

    @PostMapping(path = "/benmarks", consumes = {
        MediaType.MULTIPART_FORM_DATA_VALUE,
        MediaType.APPLICATION_JSON_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file) {
        Benmarks p = new Benmarks();
        p.setDiemthpt(Double.NaN);
        p.setDiemhocba(Double.NaN);
        p.setDiemdgnl(Double.NaN);
        p.setYear(params.get("year"));
//        p.setMajorsIdmajors(this.facultyService.getFacultyById(Integer.parseInt(params.get("facultyid"))));
        this.benmarkService.addOrUpdateBenmarks(p);
    }
}
