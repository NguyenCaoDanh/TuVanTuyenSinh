/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.pojo.ChatGPT;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.tqh.service.ChatGPTService;
import java.security.Principal;
import java.util.Collections;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author HP
 */
@Controller
public class ChatGPTController {

    @Autowired
    private ChatGPTService gptService;

    private List<ChatGPT> listGPT = new ArrayList<>();

    @GetMapping("/gpt/")
    public String gptindex(Model model) {
        model.addAttribute("gptModel", new ChatGPT());
        model.addAttribute("gptRespone", listGPT);
        return "gpt";
    }

    @PostMapping("/gpt/")
    public String add(@ModelAttribute(value = "gptModel") @Valid ChatGPT gpt, Model model, Principal u,
            BindingResult rs) {
        String respone = this.gptService.GPT(gpt.getCauHoi());
        respone = respone.replace("\\n", "</br>");
        listGPT.add(new ChatGPT(gpt.getCauHoi(), respone));
        Collections.reverse(listGPT);
        model.addAttribute("gptRespone", listGPT);
        return "gpt";
    }
}
