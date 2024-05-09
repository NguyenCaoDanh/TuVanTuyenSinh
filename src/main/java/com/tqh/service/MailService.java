/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.service;

import javax.mail.internet.InternetAddress;

/**
 *
 * @author HP
 */
public interface MailService {
    void sendHtmlMessage(InternetAddress[] to, String subject, String htmlBody);
}
