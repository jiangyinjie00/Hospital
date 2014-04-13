/*****************Cashier********************/

INSERT INTO `Cashier` (`CashierID`, `Number`, `Password`, `Name`) 
VALUES 
(1, '001', 'abc123_', '住院管理'),
(2, '002', 'abc123_', '住院管理2');

/*****************Patient*******************/
INSERT INTO `Patient` (`PatientID`, `Number`, `Sex`, `AdvancePay`, `Used`, `SelfPay`, `CreateTime`, `Name`)
VALUES
(1, '20140412001', '男', '200', '379.2', '272.24', '2014-04-12 16:55:48', '卢雪斌');

/*****************HospitalInfo*******************/
INSERT INTO `HospitalInfo` (`HospitalInfoID`, `Number`, `Department`, `Room`, `BedNumber`, `Doctor`, `CreateTime`, `MarkForDelete`, `PatientID`)
VALUES
(1, '04122014001', '内科', '1001', '1', '彭小军', '2014-04-12 16:55:48', false, 1);


/*****************Prescription*****************/
INSERT INTO `Prescription` (`PrescriptionID`, `Number`, `Name`, `Price`, `PayCoefficient`, `Unit`)
VALUES
(1, '0304140001', '感冒冲剂', 13.11, 0.5, '包'),
(2, '0304410002', '含片', 10, 0.7, '包');

/*****************Project*****************/
INSERT INTO `Project` (`ProjectID`, `Number`, `Name`, `Price`, `PayCoefficient`)
VALUES
(1, '030415001', '验血', 16, 0.7),
(2, '030415001', 'CT', 100, 0.9);

/*****************PatientPrescription*****************/
INSERT INTO `PatientPrescription` (`PatientPrescriptionID`, `Doctor`, `Department`, `Times`, `CreateTime`, `MarkForDelete`, `NotTimes`, `PrescriptionID`, `PatientID`)
VALUES
(1, '彭小军', '内科', 5, '2014-04-12 16:55:48', false, 5, 1, 1);

/*****************PatientProject*****************/
INSERT INTO `PatientProject` (`PatientProjectID`, `Doctor`, `Department`, `Times`, `CreateTime`, `MarkForDelete`, `NotTimes`, `ProjectID`, `PatientID`) 
VALUES
(1, '彭小军', '外科', 1, '2014-04-12 16:55:48', false, 1, 1, 1);