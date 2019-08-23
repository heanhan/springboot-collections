package com.example.taskjobs.service.impl;

import com.example.taskjobs.mapper.ICronsMapper;
import com.example.taskjobs.service.ICronsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : zhaojh
 * @date : 2019-08-23
 * @function :
 */

@Service
public class CronsServiceImpl implements ICronsService {

    @Autowired
    private ICronsMapper cronsMapper;

    @Override
    public String findByCronId(Integer cronId) {
        return null;
    }
}
