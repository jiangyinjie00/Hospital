package com.yzu.hospital.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.hospital.dataaccess.mapper.PatientMapperExt;
import com.yzu.hospital.dataaccess.mapper.ReceiptMapperExt;
import com.yzu.hospital.dataaccess.model.ReceiptExt;
import com.yzu.hospital.service.ReceiptService;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptMapperExt receiptMapperExt;

    @Autowired
    private PatientMapperExt patientMapperExt;

    @Override
    public ReceiptExt getReceiptByID(int receiptExtID) {
        return receiptMapperExt.getReceiptByID(receiptExtID);
    }

    @Override
    public int insertReceipt(ReceiptExt receiptExt) {
        receiptExt.setCreatetime(new Date());
        int receiptID = receiptMapperExt.insertReceipt(receiptExt);
        patientMapperExt.updateAdvancePay(receiptExt.getMoney(), receiptExt.getPatientid());
        return receiptID;
    }

    @Override
    public List<ReceiptExt> getReceiptByCashierNumber(String number, String startTime,
            String endTime) {
        return receiptMapperExt.getReceiptByCashierNumber(number, startTime, endTime);
    }
}