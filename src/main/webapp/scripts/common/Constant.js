var StatusCode = {
        // Common from 100010001.
        "HTTP_SUCCESS"                      : "0",
        "HTTP_FIAL"                         : "1"
};

var RestfulAPI = {
        "PATIENT_PATIENTINFO" : "patient/patientInfo",
        "PATIENT_PATIENTINFO_HOSPITAL" : "patient/patientInfoByNumber",
        "PATIENT_PATIENTINFO_EASY" : "patient/patientInfoEasy",
        "PATIENT_PATIENTINFO_EASY_Name" : "patient/patientInfoEasyName",
        "LOGIN" : "user/login",
        "LOGOUT" : "user/logout",
        "USER" : "user",
        "RECEIPT_SAVE" : "receipt/save",
        "RECEIPT_GET_RECEIPT_NUMBER" : "receipt/getReceiptByNumber",
        "USER_SAVE_INFORMATION" : "user/saveInfo",
        "USER_SAVE_EXPERIENCE" : "user/saveExperience",
        "USER_SAVE_EDUCATION" : "user/saveEducation",
        "USER_RESUME" : "user/getResume/:userID",
        "JOB_DETAIL" : "job/jobDetail/:jobRecruitID",
        "JOB_JOBS" : "job/jobs",
        "JOB_CREATE_JOB_REQUEST" : "job/createJobRequest",
        "JOB_CREATE_JOB_RECRUIT" : "job/createJobRecruit",
        "JOB_JOBENTITYS" : "job/jobEntitys",
        "JOB_REQUESTS" : "job/jobRequests",
        "JOB_OWNJOBREQUESTS" : "job/ownJobRequests",
        "JOB_AUDITIONJOBREQUESTS" : "job/auditionJobRequests",
        "JOB_REQUEST_DETAIL" : "job/requestDetail/:jobRequestID",
        "JOB_REQUEST_STATUS_CHANGE" : "job/requestStatusChange",
        "JOB_AUDITION" : "job/audition"
};