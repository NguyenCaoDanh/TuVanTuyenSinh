/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.pojo;

import lombok.Data;

/**
 *
 * @author HOME
 */
@Data
public class MailRequest {

    private String name;
    private String to;
    private String from;
    private String subject;
}