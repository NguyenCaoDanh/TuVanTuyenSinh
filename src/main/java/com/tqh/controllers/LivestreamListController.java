/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.service.AdmissionService;
import com.tqh.service.LivestreamService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class LivestreamListController {

    @Autowired
    private AdmissionService admissionService;
    @Autowired
    private LivestreamService livestreamService;
    @Autowired
    private Environment env;

    @GetMapping("/livestreamlist/")
    public String update(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("livestreams", this.livestreamService.getLiveStreams(params));
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        long count = this.livestreamService.countLivestreams();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "livestreamlist";
    }
}