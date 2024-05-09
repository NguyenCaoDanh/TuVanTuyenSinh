/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tqh.service;

import com.tqh.pojo.Banner;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface BannerService {

    List<Banner> getBanners(Map<String, String> params);

    Long countBanner();

    boolean addOrUpdateBanner(Banner b);

    boolean deleteBanner(int id);

    Banner getBannerById(int id);
}
