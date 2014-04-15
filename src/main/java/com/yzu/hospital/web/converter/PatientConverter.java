package com.yzu.hospital.web.converter;

import com.yzu.hospital.dataaccess.model.PatientExt;
import com.yzu.hospital.util.DateUtil;

public class PatientConverter {

    public static PatientExt converterPatient(PatientExt patientExt) {
        float afterPay = patientExt.getSelfpay() - patientExt.getAdvancepay();
        if (afterPay < 0) {
            afterPay = 0;
            patientExt.setDebt("否");
        } else {
            patientExt.setDebt("是");
        }
        patientExt.setAfterPay(afterPay);
        patientExt.setFormatCreatTime(DateUtil.dateToString(patientExt.getCreatetime()));
        return patientExt;
    }

}
