package com.yzu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.hospital.dataaccess.mapper.PatientProjectMapperExt;
import com.yzu.hospital.dataaccess.model.PatientProjectExt;
import com.yzu.hospital.service.PatientProjectService;

@Service
public class PatientProjectServiceImpl implements PatientProjectService {

    @Autowired
    private PatientProjectMapperExt patientProjectMapperExt;

    @Override
    public PatientProjectExt getPatientProjectByID(int patientProjectExtID) {
        return patientProjectMapperExt.getPatientProjectByID(patientProjectExtID);
    }

    @Override
    public int insertPatientProject(PatientProjectExt patientProjectExt) {
        return patientProjectMapperExt.insertPatientProject(patientProjectExt);
    }
}