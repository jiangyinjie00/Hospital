angular.module('hospitalApp.controller').controller('DayListCtrl', [ '$scope', '$rootScope', 'restClient', function($scope, $rootScope, restClient) {
    
    $scope.init = function() {
    	$scope.people = 3;
    };
    
    $scope.queryDayList = function() {
    	var condition = {};
    	condition.number = $scope.number;
    	condition.time = $scope.time;
    	restClient.post(RestfulAPI.RECEIPT_GET_RECEIPT_NUMBER, {}, condition).then(function() {
            $scope.dayList = restClient.getResponse();
            $scope.allMoney = 0;
            for(var index in $scope.dayList) {
            	$scope.allMoney += $scope.dayList[index].personalTotal;
            }
        });	
    };
    
    $scope.gridPatient = {
    		data : 'dayList',
    		enableSorting: false,
    		columnDefs : [],
    };
    
    $scope.gridPatient.columnDefs = [
         {
             field: 'patientExt.name',
             displayName: '姓名',
             //headerCellTemplate: $scope.headerCellTemplate,
             width:100
         },
         {
        	 field: 'patientExt.sex',
        	 displayName: '性别',
        	 //headerCellTemplate: $scope.headerCellTemplate,
        	 width:70
         },
         {
        	 field: 'patientExt.hospitalInfoExt.department',
        	 displayName: '科室',
        	 //headerCellTemplate: $scope.headerCellTemplate,
        	 width:70
         },
         {
             field: 'patientExt.hospitalInfoExt.number',
             displayName: "住院编号",
             //headerCellTemplate: $scope.headerCellTemplate,
             width:140
         },
         {
             field: 'personalTotal',
             displayName: "收入金额",
             //headerCellTemplate: $scope.headerCellTemplate,
             width:100
         },
         ];
    
} ]);