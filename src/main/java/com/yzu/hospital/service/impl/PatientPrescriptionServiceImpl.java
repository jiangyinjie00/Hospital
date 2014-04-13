package com.yzu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.hospital.dataaccess.mapper.PatientPrescriptionMapperExt;
import com.yzu.hospital.dataaccess.model.PatientPrescriptionExt;
import com.yzu.hospital.service.PatientPrescriptionService;

@Service
public class PatientPrescriptionServiceImpl implements PatientPrescriptionService {

    @Autowired
    private PatientPrescriptionMapperExt patientPrescriptionMapperExt;

    @Override
    public PatientPrescriptionExt getPatientPrescriptionByID(int patientPrescriptionID) {
        return patientPrescriptionMapperExt.getPatientPrescriptionByID(patientPrescriptionID);
    }

    @Override
    public int insertPatientPrescription(PatientPrescriptionExt patientPrescriptionExt) {
        return patientPrescriptionMapperExt.insertPatientPrescription(patientPrescriptionExt);
    }
}