angular.module('hospitalApp.controller').controller('FindPatientCtrl', [ '$scope', '$rootScope', 'restClient', function($scope, $rootScope, restClient) {
    
    $scope.init = function() {
    	$scope.people = 3;
    };
    
    $scope.queryPatient = function() {
    	var condition = {};
    	condition.people = $scope.people;
    	condition.name = $scope.name;
    	restClient.post(RestfulAPI.PATIENT_PATIENTINFO_EASY_Name, {}, condition).then(function() {
            $scope.patient = restClient.getResponse();
        });
    };
    
    $scope.gridPatient = {
    		data : 'patient',
    		enableSorting: false,
    		columnDefs : [],
    };
    
    $scope.gridPatient.columnDefs = [
         {
             field: 'number',
             displayName: '患者编号',
             //headerCellTemplate: $scope.headerCellTemplate,
             width:150
         },
         {
        	 field: 'hospitalInfoExt.number',
        	 displayName: '住院编号',
        	 //headerCellTemplate: $scope.headerCellTemplate,
        	 width:150
         },
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
             width:80
         },
         {
             field: 'hospitalInfoExt.department',
             displayName: "所在科室",
             //headerCellTemplate: $scope.headerCellTemplate,
             width:120
         },
         ];
    
} ]);