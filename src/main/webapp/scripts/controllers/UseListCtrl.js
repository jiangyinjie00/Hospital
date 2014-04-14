angular.module('hospitalApp.controller')

.controller('UseListCtrl', ['$scope', 'restClient',function($scope, restClient) {
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
          
    $scope.init = function() {
    	$scope.people = 2;
    };
            
    var template_operation = '<div class="ngCellText"><a href="#/request/{{COL_FIELD}}">查看</a></div>';
    var template_resume_operation = '<div class="ngCellText"><a href="#/resume/{{COL_FIELD}}">查看</a></div>';
       $scope.gridPrescriptions.columnDefs = [
              {
            	  field: 'prescriptionExt.number',
            	  displayName: '处方编号',
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:90
              },
              {
            	  field: 'doctor',
            	  displayName: "医生",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:90
              },
              {
            	  field: 'department',
            	  displayName: "科室",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:60
              },
              {
            	  field: 'prescriptionExt.name',
            	  displayName: "药品名称",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:130
              },
              {
            	  field: 'prescriptionExt.price',
            	  displayName: "单价",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:60
              },
              {
            	  field: 'prescriptionExt.times',
            	  displayName: "数量",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:60
              },
              {
            	  field: 'prescriptionExt.unit',
            	  displayName: "单位",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:60
              },
              {
            	  field: 'prescriptionExt.paycoefficient',
            	  displayName: "自付系数",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:80
              },
              {
            	  field: 'prescriptionExt.createtime',
            	  displayName: "类别",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:70
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
            	  width:90
              },
              {
            	  field: 'projectExt.name',
            	  displayName: "项目名称",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:150
              },
              {
            	  field: 'projectExt.price',
            	  displayName: "项目单价",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:80
              },
              {
            	  field: 'times',
            	  displayName: "次数",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:90
              },
              {
            	  field: 'projectExt.paycoefficient',
            	  displayName: "自付系数",
            	  //headerCellTemplate: $scope.headerCellTemplate,
            	  width:90
              },
              ];
    $scope.searchPatient = function() {
    	var condition = {};
    	condition.name = $scope.number;
    	condition.people = $scope.people;
        restClient.post(RestfulAPI.PATIENT_PATIENTINFO_HOSPITAL, {}, condition).then(function() {
            $scope.list = restClient.getResponse();
            $scope.patient = $scope.list;
        });
    };
}]);