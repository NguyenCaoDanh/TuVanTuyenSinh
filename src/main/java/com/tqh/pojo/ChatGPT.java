/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.pojo;

/**
 *
 * @author HP
 */
@lombok.Getter
@lombok.Setter
public class ChatGPT {

    private String cauHoi;
    private String cauTraLoi;

    public ChatGPT() {
    }

    public ChatGPT(String cauHoi, String cauTraLoi) {
        this.cauHoi = cauHoi;
        this.cauTraLoi = cauTraLoi;
    }
}
