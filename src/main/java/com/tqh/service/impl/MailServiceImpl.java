/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.service.impl;

import com.tqh.service.MailService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class MailServiceImpl implements MailService{
@Autowired
    private JavaMailSender sender;
    @Override
    public void sendHtmlMessage(InternetAddress[] to, String subject, String htmlBody) {
    
    try {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        sender.send(message);
    } catch (MessagingException ex) {
        Logger.getLogger(MailServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    }
    
}
