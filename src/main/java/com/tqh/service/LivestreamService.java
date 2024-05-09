/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.service;

import com.tqh.pojo.Livestreams;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public interface LivestreamService {

    List<Livestreams> getLiveStreams(Map<String, String> params);

    List<Livestreams> getLivestreamsByAdmission(Map<String, String> params, int id);

    Long countLivestreams(int id);

    Long countLivestreams();

    boolean addOrUpdateLivestreams(Livestreams p);

    Livestreams getLivestreamsById(int id);

    boolean deleteLivestreams(int id);
}
