package com.yzu.hospital.dataaccess.mapper;

import org.apache.ibatis.annotations.Param;

import com.yzu.hospital.dataaccess.mapper.gen.CashierMapper;
import com.yzu.hospital.dataaccess.model.CashierExt;

public interface CashierMapperExt extends CashierMapper {
    CashierExt getCashierByID(@Param("cashierID") int cashierID);

    int insertCashier(CashierExt cashierExt);

    CashierExt getCashierByName(@Param("name")String name);

    void changePassword(@Param("number")String number, @Param("password")String password);
}
