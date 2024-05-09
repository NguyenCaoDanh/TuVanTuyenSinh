/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author HP
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class FacultyDetailController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/facultiesdetail/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("faculties1", this.facultyService.getFacultyById(id));
        return "facultiesdetail";
    }
}
