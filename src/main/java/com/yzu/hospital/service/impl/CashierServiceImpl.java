package com.yzu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.hospital.dataaccess.mapper.CashierMapperExt;
import com.yzu.hospital.dataaccess.model.CashierExt;
import com.yzu.hospital.service.CashierService;

@Service
public class CashierServiceImpl implements CashierService {

    @Autowired
    private CashierMapperExt cashierMapperExt;

    public CashierExt getCashierByID(int cashierID) {
        return cashierMapperExt.getCashierByID(cashierID);
    }

    public int insertCashier(CashierExt cashierExt) {
        return cashierMapperExt.insertCashier(cashierExt);
    }

}
