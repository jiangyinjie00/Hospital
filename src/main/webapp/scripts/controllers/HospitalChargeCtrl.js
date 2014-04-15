angular.module('hospitalApp.controller')

.controller('HospitalChargeCtrl', ['$scope', 'restClient', '$rootScope', function($scope, restClient, $rootScope) {
$scope.selectedRows = [];
    
    $scope.gridPrescriptions = {
              data : 'list.patientPrescriptionExts',
              enableSorting: false,
              columnDefs : [],
          };
    $scope.gridProjects = {
    		data : 'list.patientProjectExts',
    		enableSorting: false,
    		columnDefs : [],
    };
    $scope.gridPatient = {
    		data : 'patient',
    		enableSorting: false,
    		columnDefs : [],
    };
          
    $scope.init = function() {
    	$scope.number = $scope.number = parseInt(10000000000 * Math.random());
        $scope.refresh();
    };
            
    var template_operation = '<div class="ngCellText"><a href="#/request/{{COL_FIELD}}">查看</a></div>';
    var template_resume_operation = '<div class="ngCellText"><a href="#/resume/{{COL_FIELD}}">查看</a></div>';
    // Initialize the grid option.
       $scope.gridPatient.columnDefs = [
                {
                    field: 'name',
                    displayName: '姓名',
                    //headerCellTemplate: $scope.headerCellTemplate,
                    width:100
                },
                {
                    field: 'sex',
                    displayName: "性别",
                    //headerCellTemplate: $scope.headerCellTemplate,
                    width:70
                },
                {
                    field: 'hospitalInfoExt.department',
                    displayName: "科室",
                    //headerCellTemplate: $scope.headerCellTemplate,
                    width:70
                },
                {
                    field: 'hospitalInfoExt.room',
                    displayName: "床号",
                    //headerCellTemplate: $scope.headerCellTemplate,
                    width:60
                },
                {
                    field: 'hospitalInfoExt.createtime',
                    displayName: "住院日期",
                    //headerCellTemplate: $scope.headerCellTemplate,
                    width:100
                },
                {
               	 field: 'hospitalInfoExt.doctor',
               	 displayName: "医生",
               	 //headerCellTemplate: $scope.headerCellTemplate,
               	 width:100
                },
                {
                	field: 'advancepay',
                	displayName: "预交",
                	//headerCellTemplate: $scope.headerCellTemplate,
                	width:75
                },
                {
                	field: 'used',
                	displayName: "已用",
                	//headerCellTemplate: $scope.headerCellTemplate,
                	width:75
                },
                {
                	field: 'afterPay',
                	displayName: "补交",
                	//headerCellTemplate: $scope.headerCellTemplate,
                	width:75
                },
                {
                	field: 'debt',
                	displayName: "是否欠款",
                	//headerCellTemplate: $scope.headerCellTemplate,
                	width:75
                },
       ];
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
            	  field: 'department',
            	  displayName: "科室",
            	  
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:75
              },
              {
            	  field: 'prescriptionExt.name',
            	  displayName: "药品名称",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:150
              },
              {
            	  field: 'prescriptionExt.price',
            	  displayName: "单价",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:75
              },
              {
            	  field: 'prescriptionExt.times',
            	  displayName: "数量",
            	  cellTemplate: template_resume_operation,
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:70
              },
              {
            	  field: 'prescriptionExt.unit',
            	  displayName: "单位",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:70
              },
              {
            	  field: 'prescriptionExt.category',
            	  displayName: "类别",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:70
              },
              {
            	  field: 'prescriptionExt.paycoefficient',
            	  displayName: "自付系数",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:80
              },
              ];
    
       $scope.gridProjects.columnDefs = [
              {
            	  field: 'projectExt.number',
            	  displayName: '项目编号',
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:100
              },
              {
            	  field: 'doctor',
            	  displayName: "医生",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:100
              },
              {
            	  field: 'department',
            	  displayName: "科室",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:100
              },
              {
            	  field: 'projectExt.name',
            	  displayName: "项目名称",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:180
              },
              {
            	  field: 'projectExt.price',
            	  displayName: "项目单价",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:100
              },
              {
            	  field: 'times',
            	  displayName: "次数",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:110
              },
              {
            	  field: 'projectExt.paycoefficient',
            	  displayName: "自付系数",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:110
              },
              ];
    $scope.refresh = function() {
        restClient.post(RestfulAPI.PATIENT_PATIENTINFO, {}, "20140412001").then(function() {
        	$scope.list = restClient.getResponse();
        	$scope.afterPay = $scope.list.afterPay;
        	$scope.total = $scope.list.used;
        	$scope.selfPay = $scope.list.selfpay;
            $scope.patient = [];
            $scope.patient[0] = $scope.list;
        });
    };
    
    $scope.moneyChange = function() {
    	$scope.charge = $scope.money - $scope.afterPay;
    };
    
    $scope.clearText = function() {
    	$scope.patient = null;
    	$scope.list = null;
    	$scope.afterPay = null;
    	$scope.total = null;
    	$scope.selfPay = null;
    };
    
    $scope.saveMoney = function() {
    	var receipt = {};
    	receipt.patientid = $scope.list.patientid;
    	receipt.cashierid = $rootScope.currentUser.cashierid;	
    	receipt.number = $scope.number;
    	receipt.money = $scope.afterPay;
    	
    	restClient.post(RestfulAPI.RECEIPT_SAVE, {}, receipt).then(function() {
            alert("缴费成功");
        });
    };
    
    $scope.saveMoneyCharge = function() {
    	var receipt = {};
    	receipt.patientid = $scope.list.patientid;
    	receipt.cashierid = $rootScope.currentUser.cashierid;	
    	receipt.number = $scope.number;
    	receipt.money = $scope.afterPay;
    	
    	restClient.post(RestfulAPI.RECEIPT_SAVE, {}, receipt).then(function() {
    		alert("缴费成功");
    		window.location.href = "/Hospital";
    	});
    };
    
    $scope.leavaHospital = function() {
    	if ($scope.afterPay > 0.1) {
    		alert("请先结算出院!");
    		return false;
    	}
    	restClient.post(RestfulAPI.USER_LEAVA_HOSPITAL, {}, $scope.list.patientid).then(function() {
            alert("出院成功!");
            window.location.href = "/Hospital";
        });
    };
}]);