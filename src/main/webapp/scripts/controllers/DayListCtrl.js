angular.module('hospitalApp.controller').controller('DayListCtrl', [ '$scope', '$rootScope', 'restClient', function($scope, $rootScope, restClient) {
    
    $scope.init = function() {
    	$scope.people = 3;
    };
    
    $scope.queryDayList = function() {
    	var condition = {};
    	condition.number = $scope.number;
    	condition.time = $scope.time;
    	restClient.post(RestfulAPI.RECEIPT_GET_RECEIPT_NUMBER, {}, condition).then(function() {
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