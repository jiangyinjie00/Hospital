package com.yzu.hospital.dataaccess.model;

import com.yzu.hospital.dataaccess.model.gen.Receipt;

public class ReceiptExt extends Receipt {
    private CashierExt cashierExt;
    private PatientExt patientExt;
    private float personalTotal;
    public float getPersonalTotal() {
        return personalTotal;
    }
    public void setPersonalTotal(float personalTotal) {
        this.personalTotal = personalTotal;
    }
    public CashierExt getCashierExt() {
        return cashierExt;
    }
    public void setCashierExt(CashierExt cashierExt) {
        this.cashierExt = cashierExt;
    }
    public PatientExt getPatientExt() {
        return patientExt;
    }
    public void setPatientExt(PatientExt patientExt) {
        this.patientExt = patientExt;
    }


}