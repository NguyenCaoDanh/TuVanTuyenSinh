/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.pojo.QuestionNow;
import com.tqh.service.MailService;
import java.security.Principal;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author HP
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")

public class SendQuestion {

    @Autowired
    private MailService mailService;

    @GetMapping("/questionnow/")
    public String questionindex(Model model) {
        model.addAttribute("QModel", new QuestionNow());
        return "index";
    }
    @PostMapping("/questionnow/")
    public String add(@ModelAttribute(value = "QModel") @Valid QuestionNow n, Model model, Principal u,
            BindingResult rs) throws AddressException {
        String noiDungEmail = "<p> Có câu hỏi của " + n.getHoTen() + " <br/> "
                + " Số điện thoại: " + n.getSdt() + " <br/> "
                + " Email: " + n.getEmail() + " <br/> "
                + " Nội dung câu hỏi: " + n.getCauHoi() + " </p> ";
        InternetAddress dests[] = new InternetAddress[1];
        dests[0] = new InternetAddress("2051010035danh@ou.edu.vn");
        mailService.sendHtmlMessage(dests, "Câu Hỏi", noiDungEmail);
        return "index";
    }
}
