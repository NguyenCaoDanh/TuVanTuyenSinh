/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.formatter;


import com.tqh.pojo.RoleUser;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class RoleuserFormatter implements Formatter<RoleUser>{

    @Override
    public String print(RoleUser object, Locale locale) {
        return String.valueOf(object.getIdRoleuser());
    }
    
    @Override
    public RoleUser parse(String text, Locale locale) throws ParseException {
         int id = Integer.parseInt(text);
        return new RoleUser(id);
    }
    
}
