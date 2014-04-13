package com.yzu.hospital.service;

import com.yzu.hospital.dataaccess.model.PatientProjectExt;

public interface PatientProjectService {
    PatientProjectExt getPatientProjectByID(int patientProjectExtID);

    int insertPatientProject(PatientProjectExt patientProjectExt);
}