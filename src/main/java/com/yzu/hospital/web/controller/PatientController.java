package com.yzu.hospital.web.controller;

import java.util.List;

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
import com.yzu.hospital.dataaccess.model.PatientExt;
import com.yzu.hospital.service.PatientService;
import com.yzu.hospital.web.converter.PatientConverter;
import com.yzu.hospital.web.model.QueryPatient;
import com.yzu.hospital.web.model.SaveMedicine;

@Controller
public class PatientController {
    private Logger logger = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/patient/patientInfo", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<PatientExt> getPatientByNumber(HttpServletRequest request, HttpServletResponse response,
            @RequestBody String number) {
        PatientExt patientExt = null;
        try {
            patientExt = patientService.getPatientByNumber(number);
            response.setStatus(IHttpStateCode.OK);
        } catch (Exception exception) {
            HandleWebException.handleWebException(exception, logger);
        }
        return new JsonResponse<PatientExt>(Constant.STATUS_SUCCESS, PatientConverter.converterPatient(patientExt));
    }

    @RequestMapping(value = "/patient/patientInfoMedicine", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<PatientExt> getPatientMedicineByNumber(HttpServletRequest request, HttpServletResponse response,
            @RequestBody String number) {
        PatientExt patientExt = null;
        try {
            patientExt = patientService.getPatientMedicineByNumber(number);
            response.setStatus(IHttpStateCode.OK);
        } catch (Exception exception) {
            HandleWebException.handleWebException(exception, logger);
        }
        return new JsonResponse<PatientExt>(Constant.STATUS_SUCCESS, PatientConverter.converterPatient(patientExt));
    }

    @RequestMapping(value = "/patient/patientInfoByNumber", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<PatientExt> getPatientExtByHospitalInfoNumber(HttpServletRequest request, HttpServletResponse response,
            @RequestBody QueryPatient queryPatient) {
        String number = queryPatient.getName();
        int condition = queryPatient.getPeople();
        PatientExt patientExt = null;
        try {
            patientExt = patientService.queryPatientExtByNumber(number, condition);
            response.setStatus(IHttpStateCode.OK);
        } catch (Exception exception) {
            HandleWebException.handleWebException(exception, logger);
        }
        return new JsonResponse<PatientExt>(Constant.STATUS_SUCCESS, PatientConverter.converterPatient(patientExt));
    }

    @RequestMapping(value = "/patient/patientInfoEasy", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<PatientExt> getPatientByHospitalInfoNumber(HttpServletRequest request, HttpServletResponse response,
            @RequestBody String number) {
        PatientExt patientExt = null;
        try {
            patientExt = patientService.getPatientByHospitalInfoNumber(number);
            response.setStatus(IHttpStateCode.OK);
        } catch (Exception exception) {
            HandleWebException.handleWebException(exception, logger);
        }
        return new JsonResponse<PatientExt>(Constant.STATUS_SUCCESS, PatientConverter.converterPatient(patientExt));
    }

    @RequestMapping(value = "/patient/patientInfoEasyName", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<List<PatientExt>> queryPatientByName(HttpServletRequest request, HttpServletResponse response,
            @RequestBody QueryPatient queryPatient) {
        String name = queryPatient.getName();
        int people = queryPatient.getPeople();
        List<PatientExt> patientExts = null;
        try {
            patientExts = patientService.queryPatientByName(name, people);
            response.setStatus(IHttpStateCode.OK);
        } catch (Exception exception) {
            HandleWebException.handleWebException(exception, logger);
        }
        return new JsonResponse<List<PatientExt>>(Constant.STATUS_SUCCESS, patientExts);
    }

    @RequestMapping(value = "/patient/getMedicine", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<Integer> getMedicine(HttpServletRequest request, HttpServletResponse response,
            @RequestBody SaveMedicine saveMedicine) {
        try {
            patientService.getMedicine(saveMedicine.getPrescriptionIDs());
            response.setStatus(IHttpStateCode.OK);
        } catch (Exception exception) {
            HandleWebException.handleWebException(exception, logger);
        }
        return new JsonResponse<Integer>(Constant.STATUS_SUCCESS);
    }

    @RequestMapping(value = "/user/deletePatient", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<Integer> deletePatient(HttpServletRequest request, HttpServletResponse response,
            @RequestBody int patientID) {
        try {
            patientService.deletePatientByID(patientID);
            response.setStatus(IHttpStateCode.OK);
        } catch (Exception exception) {
            HandleWebException.handleWebException(exception, logger);
        }
        return new JsonResponse<Integer>(Constant.STATUS_SUCCESS);
    }


}
