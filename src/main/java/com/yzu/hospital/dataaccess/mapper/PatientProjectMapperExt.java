package com.yzu.hospital.dataaccess.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.yzu.hospital.dataaccess.mapper.gen.PatientProjectMapper;
import com.yzu.hospital.dataaccess.model.PatientProjectExt;

public interface PatientProjectMapperExt extends PatientProjectMapper {
    PatientProjectExt getPatientProjectByID(int patientProjectExtID);

    int insertPatientProject(PatientProjectExt patientProjectExt);

    void updateMedicine(@Param("projectIDs")Set<Integer> projectIDs);
}