package com.yzu.hospital.dataaccess.mapper;

import com.yzu.hospital.dataaccess.mapper.gen.PrescriptionMapper;
import com.yzu.hospital.dataaccess.model.PrescriptionExt;

public interface PrescriptionMapperExt extends PrescriptionMapper {
    PrescriptionExt getPrescriptionByID(int prescriptionExtID);

    int insertPrescription(PrescriptionExt prescriptionExt);
}