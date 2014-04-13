package com.yzu.hospital.dataaccess.mapper;

import com.yzu.hospital.dataaccess.mapper.gen.PatientProjectMapper;
import com.yzu.hospital.dataaccess.model.PatientProjectExt;

public interface PatientProjectMapperExt extends PatientProjectMapper {
    PatientProjectExt getPatientProjectByID(int patientProjectExtID);

    int insertPatientProject(PatientProjectExt patientProjectExt);
}