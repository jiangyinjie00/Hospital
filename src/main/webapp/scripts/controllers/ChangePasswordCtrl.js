angular.module('hospitalApp.controller')
.controller('ChangePasswordCtrl', ['$scope', 'restClient', '$rootScope', function($scope, restClient, $rootScope) {
    
    $scope.init = function() {};
    
    $scope.changePassword = function() {
    	if ($scope.oldPassword != $rootScope.currentUser.password) {
    		alert("原密码不正确！");
    		return false;
    	}
    	if ($scope.password != $scope.comfirmPassword) {
    		alert("两次密码不一样！");
    		return false;
    	}
    	var user = {};
    	user.number = $rootScope.number;
    	user.passowrd = $scope.password;
    	restClient.post(RestfulAPI.USER_CHANGE_PASSWORD, {}, user).then(function(){
    		window.location.href = "/Hosptial";
    	});
    };
    
}]);