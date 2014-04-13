package com.yzu.hospital.service;

import com.yzu.hospital.dataaccess.model.CashierExt;

public interface CashierService {
    CashierExt getCashierByID(int cashierID);

    int insertCashier(CashierExt cashierExt);

    CashierExt login(String userName, String password);
}
