package com.yzu.hospital.service;

import com.yzu.hospital.dataaccess.model.HospitalInfoExt;

public interface HospitalInfoService {
    int insertHospitalInfo(HospitalInfoExt hospitalInfoExt);

    HospitalInfoExt getHospitalInfoByID(int hospitalInfoExtID);

}