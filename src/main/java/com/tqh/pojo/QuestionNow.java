/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.pojo;

import lombok.Data;

/**
 *
 * @author HP
 */
@Data
public class QuestionNow {

    private String hoTen;
    private String Email;
    private String sdt;
    private String cauHoi;
    private String heDaoTao;

    public QuestionNow() {
    }

    public QuestionNow(String hoTen, String Email, String sdt, String cauHoi, String heDaoTao) {
        this.hoTen=hoTen;
        this.Email=Email;
        this.cauHoi=cauHoi;
        this.sdt=sdt;
        this.heDaoTao=heDaoTao;
    }
}
