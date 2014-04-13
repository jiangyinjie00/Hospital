package com.yzu.hospital.service;

import com.yzu.hospital.dataaccess.model.PrescriptionExt;

public interface PrescriptionService {
    PrescriptionExt getPrescriptionByID(int prescriptionExtID);

    int insertPrescription(PrescriptionExt prescriptionExt);
}