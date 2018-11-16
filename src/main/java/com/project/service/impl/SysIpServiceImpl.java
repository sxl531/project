package com.project.service.impl;

import com.project.dao.TbSysIpMapper;
import com.project.entity.SysIp;
import com.project.service.ISysIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysIpServiceImpl implements ISysIpService {

    @Autowired
    private TbSysIpMapper sysIpMapper;


    @Override
    public List<SysIp> findByIp(String ip) {
        if(ip == null ){
            return  null;
        }

        try{
            ip = ip.substring(0,6);
        }catch (Exception e){
            return null;
        }

        return sysIpMapper.selectByIp(ip);
    }
}
