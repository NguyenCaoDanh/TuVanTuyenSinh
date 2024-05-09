/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.pojo.Benmarks;
import com.tqh.service.BenmarkService;
import com.tqh.service.FacultyService;
import com.tqh.service.MajorService;
import java.security.Principal;
import java.util.Map;
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

/**
 *
 * @author HP
 */
@Controller
@PropertySource("classpath:configs.properties")
public class BenmarkController {

    @Autowired
    private BenmarkService benmarkService;
    @Autowired
    private MajorService majorService;

    @GetMapping("/benmarks")
    public String list1(Model model, Principal p, Map<String, String> params) {
        model.addAttribute("benmarks", this.benmarkService.getBenMarks(params));
        return "benmarks";
    }

    @GetMapping("admin/benmarks")
    public String list(Model model, Principal p) {
        model.addAttribute("benmarks", new Benmarks());
        return "benmarksetting";
    }

    @GetMapping("admin/benmarks/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("benmarks", this.benmarkService.getBenmarksById(id));
        return "benmarksetting";
    }

    @PostMapping("admin/benmarks")
    public String add(@ModelAttribute(value = "benmarks") @Valid Benmarks p,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (benmarkService.addOrUpdateBenmarks(p) == true) {
                return "redirect:/";
            }
        }
        return "benmarksetting";
    }
}
