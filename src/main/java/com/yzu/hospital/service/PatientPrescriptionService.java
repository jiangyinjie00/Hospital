package com.yzu.hospital.service;

import com.yzu.hospital.dataaccess.model.PatientPrescriptionExt;

public interface PatientPrescriptionService {
    PatientPrescriptionExt getPatientPrescriptionByID(int patientPrescriptionID);

    int insertPatientPrescription(PatientPrescriptionExt patientPrescriptionExt);
}