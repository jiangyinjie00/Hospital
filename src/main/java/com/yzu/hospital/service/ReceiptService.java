package com.yzu.hospital.service;

import com.yzu.hospital.dataaccess.model.ReceiptExt;

public interface ReceiptService {
    ReceiptExt getReceiptByID(int receiptExtID);

    int insertReceipt(ReceiptExt receiptExt);
}