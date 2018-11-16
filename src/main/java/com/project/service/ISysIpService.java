package com.project.service;

import com.project.entity.SysIp;

import java.util.List;

public interface ISysIpService {

    /**
     * 通过ip值获取列表信息
     * @param ip
     * @return
     */
    List<SysIp> findByIp(String ip);
}
