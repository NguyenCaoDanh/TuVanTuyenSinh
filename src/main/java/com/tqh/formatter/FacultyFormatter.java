/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.formatter;

import com.tqh.pojo.Faculty;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author HP
 */
public class FacultyFormatter implements Formatter<Faculty> {

    @Override
    public String print(Faculty object, Locale locale) {
        return String.valueOf(object.getIdfaculty());
    }

    @Override
    public Faculty parse(String text, Locale locale) throws ParseException {
        int id = Integer.parseInt(text);
        return new Faculty(id);
    }

}
