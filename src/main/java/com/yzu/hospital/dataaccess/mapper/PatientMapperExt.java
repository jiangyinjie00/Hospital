package com.yzu.hospital.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yzu.hospital.dataaccess.mapper.gen.PatientMapper;
import com.yzu.hospital.dataaccess.model.PatientExt;

public interface PatientMapperExt extends PatientMapper {
    int insertPatient(PatientExt patientExt);

    PatientExt getPatientByID(int patientExtID);

    PatientExt getPatientByNumber(@Param("number")String number);

    PatientExt getPatientByHospitalInfoNumber(@Param("number")String number);

    void updateAdvancePay(@Param("money")float money, @Param("patientID")int patientID);

    List<PatientExt> queryPatientByName(@Param("name")String name, @Param("condition")String condition);

    PatientExt queryPatientExtByNumber(@Param("number")String number, @Param("condition")int condition);

    PatientExt getPatientMedicineByNumber(@Param("number")String number);

    void markForDelete(@Param("patientID")int patientID);
}