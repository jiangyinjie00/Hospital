package com.yzu.hospital.dataaccess.mapper;

import com.yzu.hospital.dataaccess.mapper.gen.PatientPrescriptionMapper;
import com.yzu.hospital.dataaccess.model.PatientPrescriptionExt;

public interface PatientPrescriptionMapperExt extends PatientPrescriptionMapper {
    PatientPrescriptionExt getPatientPrescriptionByID(int patientPrescriptionID);

    int insertPatientPrescription(PatientPrescriptionExt patientPrescriptionExt);
}