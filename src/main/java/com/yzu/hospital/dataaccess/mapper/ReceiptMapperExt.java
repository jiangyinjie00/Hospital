package com.yzu.hospital.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yzu.hospital.dataaccess.mapper.gen.ReceiptMapper;
import com.yzu.hospital.dataaccess.model.ReceiptExt;

public interface ReceiptMapperExt extends ReceiptMapper {
    ReceiptExt getReceiptByID(int receiptExtID);

    int insertReceipt(ReceiptExt receiptExt);

    List<ReceiptExt> getReceiptByCashierNumber(@Param("number") String number,
            @Param("startTime") String startTime, @Param("endTime") String endTime);
}