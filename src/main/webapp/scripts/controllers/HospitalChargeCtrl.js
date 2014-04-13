angular.module('hospitalApp.controller')

.controller('HospitalChargeCtrl', ['$scope', 'restClient',function($scope, restClient) {
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
                	field: 'advancepay',
                	displayName: "补交",
                	//headerCellTemplate: $scope.headerCellTemplate,
                	width:75
                },
                {
                	field: 'userid',
                	displayName: "是否欠款",
                	cellTemplate: template_resume_operation,
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
            $scope.patient = [];
            $scope.patient[0] = $scope.list;
        });
    };
}]);