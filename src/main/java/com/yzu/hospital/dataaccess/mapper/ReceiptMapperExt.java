package com.yzu.hospital.dataaccess.mapper;

import com.yzu.hospital.dataaccess.mapper.gen.ReceiptMapper;
import com.yzu.hospital.dataaccess.model.ReceiptExt;

public interface ReceiptMapperExt extends ReceiptMapper {
    ReceiptExt getReceiptByID(int receiptExtID);

    int insertReceipt(ReceiptExt receiptExt);
}