/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.pojo.School;
import com.tqh.service.SchoolService;
import java.security.Principal;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author HP
 */
@Controller
public class SchoolController {
    @Autowired
    private SchoolService schoolService;
    
    @GetMapping("/school")
    public String list1(Model model, Principal p,Map<String, String> params) {
        model.addAttribute("school",this.schoolService.getSchool(params));
        return "school";
    }
    @GetMapping("/admin/school")
    public String list(Model model, Principal p) {
        model.addAttribute("school", new School());
        return "schoolsetting";
    }

    @GetMapping("/admin/school/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("school", this.schoolService.getSchoolById(id));
        return "schoolsetting";
    }

    @PostMapping("/admin/school")
    public String add(@ModelAttribute(value = "school") @Valid School p,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (schoolService.addOrUpdateSChool(p) == true) {
                return "redirect:/";
            }
        }
        return "schoolsetting";
    }
}
