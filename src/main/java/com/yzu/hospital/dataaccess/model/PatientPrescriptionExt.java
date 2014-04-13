package com.yzu.hospital.dataaccess.model;

import com.yzu.hospital.dataaccess.model.gen.PatientPrescription;

public class PatientPrescriptionExt extends PatientPrescription {

    private PrescriptionExt prescriptionExt;

    public PrescriptionExt getPrescriptionExt() {
        return prescriptionExt;
    }

    public void setPrescriptionExt(PrescriptionExt prescriptionExt) {
        this.prescriptionExt = prescriptionExt;
    }


}