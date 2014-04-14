package com.yzu.hospital.service;

import java.util.List;

import com.yzu.hospital.dataaccess.model.ReceiptExt;

public interface ReceiptService {
    ReceiptExt getReceiptByID(int receiptExtID);

    int insertReceipt(ReceiptExt receiptExt);

    List<ReceiptExt> getReceiptByCashierNumber(String number, String startTime, String endTime);
}