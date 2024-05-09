/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.pojo.Majors;
import com.tqh.service.MajorService;
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
@Controller
@RequestMapping("/admin")
@PropertySource("classpath:configs.properties")
public class MajorController {
     @Autowired
    private MajorService majorService;

    @GetMapping("/majors")
    public String list(Model model, Principal p) {
        model.addAttribute("major", new Majors());
        return "majors";
    }

    @GetMapping("/majors/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("major", this.majorService.getMajorsById(id));
        return "majors";
    }

    @PostMapping("/majors")
    public String add(@ModelAttribute(value = "major") @Valid Majors f,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (majorService.addOrUpdateMajors(f) == true) {
                return "redirect:/";
            }
        }
        return "majors";
    }
}
