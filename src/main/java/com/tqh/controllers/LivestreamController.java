/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.pojo.Livestreams;
import com.tqh.service.AdmissionService;
import com.tqh.service.FacultyService;
import com.tqh.service.LivestreamService;
import java.security.Principal;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
@RequestMapping("/admin")
@Controller
@PropertySource("classpath:configs.properties")
public class LivestreamController {

    @Autowired
    private LivestreamService livestreamService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private AdmissionService admissionService;
    @Autowired
    private Environment env;

    @GetMapping("/livestreams")
    public String list(Model model, Principal p) {
        model.addAttribute("livestream", new Livestreams());
        return "livestreams";
    }

    @GetMapping("/livestreams/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("livestream", this.livestreamService.getLivestreamsById(id));
        return "livestreams";
    }

    @PostMapping("/livestreams")
    public String add(@ModelAttribute(value = "livestream") @Valid Livestreams p,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (livestreamService.addOrUpdateLivestreams(p) == true) {
                return "redirect:/";
            }
        }
        return "livestreams";
    }

    @RequestMapping("/livestreams")
    public String list(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("dslivestream", this.livestreamService.getLiveStreams(params));
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        long count = this.livestreamService.countLivestreams();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "livestreams";
    }
}
