package com.yzu.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.hospital.dataaccess.mapper.PatientMapperExt;
import com.yzu.hospital.dataaccess.mapper.PatientPrescriptionMapperExt;
import com.yzu.hospital.dataaccess.mapper.PatientProjectMapperExt;
import com.yzu.hospital.dataaccess.model.PatientExt;
import com.yzu.hospital.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientMapperExt patientMapperExt;

    @Autowired
    private PatientPrescriptionMapperExt patientPrescriptionMapperExt;

    @Autowired
    private PatientProjectMapperExt patientProjectMapperExt;

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

    @Override
    public PatientExt queryPatientExtByNumber(String number, int condition) {
        return patientMapperExt.queryPatientExtByNumber(number, condition);
    }


    @Override
    public PatientExt getPatientMedicineByNumber(String number) {

        return patientMapperExt.getPatientMedicineByNumber(number);
    }

    @Override
    public void getMedicine(int[] prescriptionIDs) {
        patientPrescriptionMapperExt.updateMedicine(prescriptionIDs);
    }

    @Override
    public void deletePatientByID(int patientID) {
        patientMapperExt.markForDelete(patientID);

    }
}