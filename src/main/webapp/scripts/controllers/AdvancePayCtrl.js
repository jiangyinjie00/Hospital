angular.module('hospitalApp.controller')
.controller('AdvancePayCtrl', ['$scope', 'restClient', '$rootScope', function($scope, restClient, $rootScope) {
    
    $scope.init = function() {
    	$scope.number = parseInt(10000000000 * Math.random());
    };
    
    $scope.searchHospitalInfo = function() {
    	var number = $scope.hospitalInfoNumber;
    	restClient.post(RestfulAPI.PATIENT_PATIENTINFO_EASY, {}, number).then(function() {
            $scope.patient = restClient.getResponse();
        });
    };
    
    $scope.saveAdvancePay = function() {
    	var receipt = {};
    	receipt.patientid = $scope.patient.patientid;
    	receipt.cashierid = $rootScope.currentUser.cashierid;
    	receipt.number = $scope.number;
    	receipt.money = $scope.money;
    	
    	restClient.post(RestfulAPI.RECEIPT_SAVE, {}, receipt).then(function() {
            alert("缴费成功");
            window.location.href = "/Hospital";
        });
    };
    
}]);