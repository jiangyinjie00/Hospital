package com.yzu.hospital.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.yzu.hospital.dataaccess.model.ReceiptExt;
import com.yzu.hospital.service.ReceiptService;

@Controller
public class ReceiptController {
    private Logger logger = LoggerFactory.getLogger(ReceiptController.class);

    @Autowired
    private ReceiptService receiptService;

    @RequestMapping(value = "/receipt/save", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<Integer> saveReceipt(HttpServletRequest request, HttpServletResponse response,
            @RequestBody ReceiptExt receiptExt) {
        try {
            int receiptID = receiptService.insertReceipt(receiptExt);
            response.setStatus(IHttpStateCode.OK);
        } catch (Exception exception) {
            HandleWebException.handleWebException(exception, logger);
        }
        return new JsonResponse<Integer>(Constant.STATUS_SUCCESS);
    }

}
