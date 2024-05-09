/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.formatter;

import com.tqh.pojo.Majors;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author HP
 */
public class MajorFormatter implements Formatter<Majors> {

    @Override
    public String print(Majors object, Locale locale) {
        return String.valueOf(object.getIdmajors());
    }

    @Override
    public Majors parse(String text, Locale locale) throws ParseException {
        int id = Integer.parseInt(text);
        return new Majors(id);
    }

}
