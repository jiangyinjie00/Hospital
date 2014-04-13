package com.yzu.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.hospital.dataaccess.mapper.PatientMapperExt;
import com.yzu.hospital.dataaccess.model.PatientExt;
import com.yzu.hospital.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientMapperExt patientMapperExt;

    @Override
    public int insertPatient(PatientExt patientExt) {
        return patientMapperExt.insertPatient(patientExt);
    }

    @Override
    public PatientExt getPatientByID(int patientExtID) {
        return patientMapperExt.getPatientByID(patientExtID);
    }

    @Override
    public PatientExt getPatientByNumber(String number) {

        return patientMapperExt.getPatientByNumber(number);
    }

    @Override
    public PatientExt getPatientByHospitalInfoNumber(String number) {
        return patientMapperExt.getPatientByHospitalInfoNumber(number);
    }

    @Override
    public List<PatientExt> queryPatientByName(String name, int people) {
        String condition = null;
        if (people == 1) {
            condition = "男";
        } else if (people == 2) {
            condition = "女";
        }
        return patientMapperExt.queryPatientByName(name, condition);
    }
}