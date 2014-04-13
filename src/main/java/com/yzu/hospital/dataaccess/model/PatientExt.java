package com.yzu.hospital.dataaccess.model;

import java.util.List;

import com.yzu.hospital.dataaccess.model.gen.Patient;

public class PatientExt extends Patient {

    private HospitalInfoExt hospitalInfoExt;
    private List<PatientPrescriptionExt> patientPrescriptionExts;
    private List<PatientProjectExt> patientProjectExts;
    private float afterPay;
    private String debt;
    private String formatCreatTime;

    public HospitalInfoExt getHospitalInfoExt() {
        return hospitalInfoExt;
    }

    public void setHospitalInfoExt(HospitalInfoExt hospitalInfoExt) {
        this.hospitalInfoExt = hospitalInfoExt;
    }

    public List<PatientPrescriptionExt> getPatientPrescriptionExts() {
        return patientPrescriptionExts;
    }

    public void setPatientPrescriptionExts(List<PatientPrescriptionExt> patientPrescriptionExts) {
        this.patientPrescriptionExts = patientPrescriptionExts;
    }

    public List<PatientProjectExt> getPatientProjectExts() {
        return patientProjectExts;
    }

    public void setPatientProjectExts(List<PatientProjectExt> patientProjectExts) {
        this.patientProjectExts = patientProjectExts;
    }

    public float getAfterPay() {
        return afterPay;
    }

    public void setAfterPay(float afterPay) {
        this.afterPay = afterPay;
    }

    public String getDebt() {
        return debt;
    }

    public void setDebt(String debt) {
        this.debt = debt;
    }

    public String getFormatCreatTime() {
        return formatCreatTime;
    }

    public void setFormatCreatTime(String formatCreatTime) {
        this.formatCreatTime = formatCreatTime;
    }

}