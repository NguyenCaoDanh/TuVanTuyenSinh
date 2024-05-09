/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.formatter;

import com.tqh.pojo.Admission;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author HP
 */
public class AdmissionFormatter implements Formatter<Admission>{

    @Override
    public String print(Admission object, Locale locale) {
       return String.valueOf(object.getIdadmission());
    }

    @Override
    public Admission parse(String text, Locale locale) throws ParseException {
        int id = Integer.parseInt(text);
        return new Admission(id);
    }
    
}
