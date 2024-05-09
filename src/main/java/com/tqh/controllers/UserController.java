/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.pojo.Users;
import com.tqh.service.RoleUserService;
import com.tqh.service.UserService;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Map;
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
 * @author Admin
 */
@Controller
@PropertySource("classpath:configs.properties")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private Environment env;
    @Autowired
    private RoleUserService roleuserService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute(value = "user") @Valid Users u, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (userService.addOrUpdateUser(u) == true) {
                return "redirect:/login";
            }
        }
        return "register";
    }

    @GetMapping("/admin/user1")
    public String list(Model model, Principal p) {
        model.addAttribute("users", new Users());
        return "user1";
    }
    @GetMapping("/admin/usersetting")
    public String list1(Model model, Principal p) {
        model.addAttribute("users", new Users());
        return "usersetting";
    }
    @GetMapping("/admin/user1/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("users", this.userService.getUserByLogin(id));
        return "user1";
    }

    @PostMapping("/admin/user1")
    public String add(@ModelAttribute(value = "user") @Valid Users u,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (userService.addOrUpdateUser(u) == true) {
                return "redirect:/";
            }
        }
        return "user1";
    }
    
     @GetMapping("/accoutsetting")
    public String update1(Model model,Principal u) {
        Users user= this.userService.getUserByUn(u.getName());
        model.addAttribute("users", user);
        return "accoutsetting";
    }

    @PostMapping("/accoutsetting")
    public String add1(@ModelAttribute(value = "user") @Valid Users u,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (userService.addOrUpdateUser(u) == true) {
                return "redirect:/";
            }
        }
        return "accoutsetting";
    }
}
