package com.yzu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.hospital.dataaccess.mapper.PrescriptionMapperExt;
import com.yzu.hospital.dataaccess.model.PrescriptionExt;
import com.yzu.hospital.service.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionMapperExt prescriptionMapperExt;

    @Override
    public PrescriptionExt getPrescriptionByID(int prescriptionExtID) {
        return prescriptionMapperExt.getPrescriptionByID(prescriptionExtID);
    }

    @Override
    public int insertPrescription(PrescriptionExt prescriptionExt) {
        return prescriptionMapperExt.insertPrescription(prescriptionExt);
    }
}