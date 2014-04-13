package com.yzu.hospital.dataaccess.mapper;

import com.yzu.hospital.dataaccess.mapper.gen.HospitalInfoMapper;
import com.yzu.hospital.dataaccess.model.HospitalInfoExt;

public interface HospitalInfoMapperExt extends HospitalInfoMapper {
    int insertHospitalInfo(HospitalInfoExt hospitalInfoExt);

    HospitalInfoExt getHospitalInfoByID(int hospitalInfoExtID);

}