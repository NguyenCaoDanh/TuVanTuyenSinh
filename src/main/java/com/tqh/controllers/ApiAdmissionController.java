/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.tqh.controllers;


import com.tqh.pojo.Admission;
import com.tqh.service.AdmissionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/api")
public class ApiAdmissionController {
    @Autowired
    public AdmissionService admissionService;
    
    @GetMapping("/admissions/")
    @CrossOrigin
    public ResponseEntity<List<Admission>> list() {
        return new ResponseEntity<>(this.admissionService.getAdmissions(), HttpStatus.OK);
    }
}
