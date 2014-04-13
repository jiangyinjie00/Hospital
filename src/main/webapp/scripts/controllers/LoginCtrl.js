angular.module('hospitalApp.controller')

.controller('LoginCtrl', ['$scope', 'userService', 'restClient', function($scope, userService, restClient) {
	
	$scope.init = function() {
		$scope.user = {};
		$scope.user.name = "住院管理";
		$scope.user.password = "abc123_";
	};
	
    $scope.login = function(invalid) {
    	
        restClient.post(RestfulAPI.LOGIN, {}, $scope.user).then(function(){
        	userService.getCurrentUser();
        	window.location.href = "/Hospital";
        },function(){
            $("#login-error").show();
        });
        
    };
}]);