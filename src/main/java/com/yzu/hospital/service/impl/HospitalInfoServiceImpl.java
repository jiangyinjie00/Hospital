package com.yzu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.hospital.dataaccess.mapper.HospitalInfoMapperExt;
import com.yzu.hospital.dataaccess.model.HospitalInfoExt;
import com.yzu.hospital.service.HospitalInfoService;

@Service
public class HospitalInfoServiceImpl implements HospitalInfoService {

    @Autowired
    private HospitalInfoMapperExt hospitalInfoMapperExt;

    @Override
    public int insertHospitalInfo(HospitalInfoExt hospitalInfoExt) {
        return hospitalInfoMapperExt.insertHospitalInfo(hospitalInfoExt);
    }

    @Override
    public HospitalInfoExt getHospitalInfoByID(int hospitalInfoExtID) {
        return hospitalInfoMapperExt.getHospitalInfoByID(hospitalInfoExtID);
    }

}