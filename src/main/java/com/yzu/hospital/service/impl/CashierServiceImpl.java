package com.yzu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.hospital.common.ErrorCode;
import com.yzu.hospital.dataaccess.mapper.CashierMapperExt;
import com.yzu.hospital.dataaccess.model.CashierExt;
import com.yzu.hospital.exception.ArgumentException;
import com.yzu.hospital.service.CashierService;

@Service
public class CashierServiceImpl implements CashierService {

    @Autowired
    private CashierMapperExt cashierMapperExt;

    @Override
    public CashierExt getCashierByID(int cashierID) {
        return cashierMapperExt.getCashierByID(cashierID);
    }

    @Override
    public int insertCashier(CashierExt cashierExt) {
        return cashierMapperExt.insertCashier(cashierExt);
    }

    @Override
    public CashierExt login(String userName, String password) {
        CashierExt cashierExt = cashierMapperExt.getCashierByName(userName);
        if (password.equals(cashierExt.getPassword())) {
            return cashierExt;
        }
        String errorMessage = "username or password is not right";
        throw new ArgumentException(errorMessage, ErrorCode.USER_NAME_PASSWORD_ERROR);
    }

    @Override
    public void changePassword(String number, String password) {
        cashierMapperExt.changePassword(number, password);

    }

}
