angular.module('hospitalApp.controller')

.controller('PharmacyCtrl', ['$scope', 'restClient',function($scope, restClient) {
$scope.selectedRows = [];
    
    $scope.gridPrescriptions = {
              data : 'prescriptions',
              enableSorting: false,
              columnDefs : [],
          };
    $scope.gridPrescriptionDetails = {
            data : 'prescriptions',
            enableSorting: false,
            columnDefs : [],
    };
          
    $scope.init = function() {
    };
            
   $scope.gridPrescriptions.columnDefs = [
          {
              field: 'prescriptionExt.number',
              displayName: '处方编号',
              //headerCellTemplate: $scope.headerCellTemplate,
              width:110
          },
          {
              field: 'doctor',
              displayName: "医生",
              //headerCellTemplate: $scope.headerCellTemplate,
              width:100
          },
          {
              field: 'name',
              displayName: "患者姓名",
              //headerCellTemplate: $scope.headerCellTemplate,
              width:85
          },
          {
        	  field: 'sex',
        	  displayName: "性别",
        	  //headerCellTemplate: $scope.headerCellTemplate,
        	  width:85
          },
          {
        	  field: 'liveTime',
        	  displayName: "住院时间",
        	  //headerCellTemplate: $scope.headerCellTemplate,
        	  width:120
          },
          
          ];

   $scope.gridPrescriptionDetails.columnDefs = [
            {
                  field: 'prescriptionExt.name',
                  displayName: "药品名称",
                  //headerCellTemplate: $scope.headerCellTemplate,
                  width:180
            },
            {
                  field: 'times',
                  displayName: "数量",
                  //headerCellTemplate: $scope.headerCellTemplate,
                  width:100
            },
            {
                  field: 'prescriptionExt.unit',
                  displayName: "单位",
                  //headerCellTemplate: $scope.headerCellTemplate,
                  width:110
            },
            {
                field: 'nottimes',
                displayName: "未出库数",
                //headerCellTemplate: $scope.headerCellTemplate,
                width:110
            },
          ];
    $scope.searchPatient = function() {
        restClient.post(RestfulAPI.PATIENT_PATIENTINFO_MEDICINE, {}, "20140412001").then(function() {
            $scope.list = restClient.getResponse();
            if (null == $scope.list) {
            	alert("没有未完成处方单");
            	return false;
            }
            var prescriptions = $scope.list.patientPrescriptionExts;
            for (var index in prescriptions) {
                prescriptions[index].name = $scope.list.name;
                prescriptions[index].sex = $scope.list.sex;
                prescriptions[index].liveTime = $scope.list.createtime;
            }
            $scope.prescriptions = prescriptions;
        });
    };
    
    $scope.updateMedicine = function() {
    	var patient = $scope.list;
    	var prescriptions = patient.patientPrescriptionExts;
    	var prescriptionIDs = [];
    	if (null != prescriptions) {
    		for (var index in prescriptions) {
    			prescriptionIDs.push(prescriptions[index].patientprescriptionid);
    		}
    	} else {
    		return false;
    	}
    	var condition = {};
    	condition.prescriptionIDs = prescriptionIDs;
    	restClient.post(RestfulAPI.PATIENT_UPDATEMEDICINE, {}, condition).then(function() {
    		alert("取药成功");
    		$scope.clearText();
    	});
    };
    
    $scope.clearText = function() {
    	$scope.list = null;
    	$scope.prescriptions = null;
    	$scope.number = "";
    };
}]);