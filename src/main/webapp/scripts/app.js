angular.module('hospitalApp', [ 'hospitalApp.controller', 'hospitalApp.services', 'hospitalApp.directive', 'hospitalApp.restful','ngGrid', 'ui.bootstrap.dialog']);
angular.module('hospitalApp.controller', []);
angular.module('hospitalApp.services', []);
//angular.module('ngGrid', []);
angular.module('hospitalApp.directive', []);
angular.module('hospitalApp.restful', [ 'ngResource' ]);
angular.module('hospitalApp').config([ '$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
    $routeProvider.when('', {
        templateUrl : 'views/home.html',
        controller : 'HomeCtrl'
    }).when('/hospitalCharge', {
        templateUrl : 'views/hospitalCharge.html',
        controller : 'HospitalChargeCtrl'
    }).when('/advancePay', {
        templateUrl : 'views/advancePay.html',
        controller : 'AdvancePayCtrl'
    }).when('/queryPatient', {
        templateUrl : 'views/findPatient.html',
        controller : 'FindPatientCtrl'
    }).when('/pharmacy', {
        templateUrl : 'views/pharmacy.html',
        controller : 'PharmacyCtrl'
    }).when('/leaveHospital', {
    	templateUrl : 'views/leaveHospital.html',
    	controller : 'HospitalChargeCtrl'
    }).when('/dayList', {
    	templateUrl : 'views/dayList.html',
    	controller : 'DayListCtrl'
    }).when('/backStage', {
	templateUrl : 'views/backStage.html',
	controller : 'BackStageCtrl'
    }).when('/resume/:userID', {
        templateUrl : 'views/resumeDetail.html',
        controller : 'ResumeCtrl'
    }).when('/request/:jobRequestID', {
		templateUrl : 'views/requestDetail.html',
		controller : 'RequestCtrl'
	}).when('/audition', {
		templateUrl : 'views/audition.html',
		controller : 'AuditionCtrl'
	}).when('/ownRequests', {
	templateUrl : 'views/ownRequests.html',
	controller : 'RequestCtrl'
});
    
    $httpProvider.responseInterceptors.push([ '$rootScope', '$q', '$location', function($rootScope, $q, $location) {
        return function(promise) {
            return promise.then(
            // if success, don't intercept
            function success(response) {
                if (response.data && (response.data.status == -1 || response.data.status == -2)) {
                    $rootScope.globalErrorMessage = response.data.errorMessage;
                    $rootScope.$broadcast('event:serverError');
                }
                
                return response;
            },

            function error(response) {
                
                // test true SecurityRegExp.test(response.config.url)
                if (true) {
                    // if 401, broadcast an login required event.
                    if (response.status === 401) {
                        $rootScope.$broadcast('event:loginRequired');
                    }
                    
                    // if 404, broadcast an not found required event.
                    if (response.status === 404) {
                        $rootScope.$broadcast('event:notFoundRequired');
                    }
                    
                    // if 403, broadcast an access denied required event.
                    if (response.status === 403) {
                        $rootScope.$broadcast('event:accessDenied');
                    }
                }
                
                return $q.reject(response);
            });
        };
    } ]);
    
} ]);

// Run the hospital module.
angular.module('hospitalApp').run([ '$rootScope', '$location', 'userService', function($rootScope, $location, userService) {
    $rootScope.report = 0;
    $rootScope.$on('event:serverError', function() {
        if ($location.path() !== "/login") {
            $location.path("/500");
        }
        
    });
    
    $rootScope.$on('$routeChangeStart', function(event, next, current){
    	
        //Get current user and set it to root scope
        userService.getCurrentUser();
        
    });
    
    $rootScope.$on('event:loginRequired', function() {
        window.location.href = "login.html";
    });
    
    $rootScope.$on('event:notFoundRequired', function() {
        $location.path("/404");
    });
    
    $rootScope.$on('event:loginRequired', function() {
        $location.path("/403");
    });
} ]);
