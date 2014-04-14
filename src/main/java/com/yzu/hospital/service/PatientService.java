package com.yzu.hospital.service;

import java.util.List;

import com.yzu.hospital.dataaccess.model.PatientExt;

public interface PatientService {
    int insertPatient(PatientExt patientExt);

    PatientExt getPatientByID(int patientExtID);

    PatientExt getPatientByNumber(String number);

    PatientExt getPatientByHospitalInfoNumber(String number);

    List<PatientExt> queryPatientByName(String name, int people);

    PatientExt queryPatientExtByNumber(String number, int condition);
}