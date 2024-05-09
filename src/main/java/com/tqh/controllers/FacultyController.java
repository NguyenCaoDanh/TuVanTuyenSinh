/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.pojo.Faculty;
import com.tqh.service.FacultyService;
import java.security.Principal;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP
 */
@RequestMapping("/admin")
@Controller
@PropertySource("classpath:configs.properties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/faculties")
    public String list(Model model, Principal p) {
        model.addAttribute("faculty", new Faculty());
        return "faculties";
    }

    @GetMapping("/faculties/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("faculty", this.facultyService.getFacultyById(id));
        return "faculties";
    }

    @PostMapping("/faculties")
    public String add(@ModelAttribute(value = "faculty") @Valid Faculty f,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (facultyService.addOrUpdateFaculty(f) == true) {
                return "redirect:/";
            }
        }
        return "faculties";
    }

}
