package com.yzu.hospital.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzu.hospital.common.Constant;
import com.yzu.hospital.common.HandleWebException;
import com.yzu.hospital.common.IHttpStateCode;
import com.yzu.hospital.common.JsonResponse;
import com.yzu.hospital.common.Logger;
import com.yzu.hospital.common.LoggerFactory;
import com.yzu.hospital.dataaccess.model.CashierExt;
import com.yzu.hospital.service.CashierService;

@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private CashierService cashierService;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<Integer> login(HttpServletRequest request, HttpServletResponse response,
            @RequestBody CashierExt cashierExt) {
        String userName = cashierExt.getName();
        String password = cashierExt.getPassword();
        try {
            CashierExt cashier = cashierService.login(userName, password);
            HttpSession session = request.getSession();
            session.setAttribute("USER", cashier);
            response.setStatus(IHttpStateCode.OK);
        } catch (Exception exception) {
            HandleWebException.handleWebException(exception, logger);
        }
        return new JsonResponse<Integer>(Constant.STATUS_SUCCESS);
    }

    @RequestMapping(value = "/user/logout", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<Integer> logout(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            response.setStatus(IHttpStateCode.OK);
        } catch (Exception exception) {
            HandleWebException.handleWebException(exception, logger);
        }
        return new JsonResponse<Integer>(Constant.STATUS_SUCCESS);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResponse<CashierExt> getCurrentUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        CashierExt userModel = (CashierExt) session.getAttribute("USER");
        if (null == userModel) {
            response.setStatus(IHttpStateCode.UNAUTHORIZED);
            return null;
        } else {
            response.setStatus(IHttpStateCode.OK);
            return new JsonResponse<CashierExt>(Constant.STATUS_SUCCESS, userModel);
        }
    }

}
