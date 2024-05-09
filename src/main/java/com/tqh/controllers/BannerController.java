/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.pojo.Banner;
import com.tqh.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.security.Principal;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@RequestMapping("/admin")
@Controller
@PropertySource("classpath:configs.properties")
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @GetMapping("/banners")
    public String list(Model model, Principal p) {
        model.addAttribute("banner", new Banner());
        return "banners";
    }
    @GetMapping("/banners/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("banner", this.bannerService.getBannerById(id));
        return "banners";
    }
     @PostMapping("/banners")
    public String add(@ModelAttribute(value = "banner") @Valid Banner b,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (bannerService.addOrUpdateBanner(b) == true) {
                return "redirect:/";
            }
        }

        return "banners";
    }
    
}
