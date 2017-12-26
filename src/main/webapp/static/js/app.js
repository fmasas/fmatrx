 
var App = angular.module('myApp', ['ngRoute']);
App.config(['$routeProvider', function($routeProvider) {
	
    $routeProvider.
    
    when('/orders', {
       templateUrl: 'orders.htm',
       controller: 'OrderController'
    }).
    
    when('/orderDetail/:param1', {
       templateUrl: 'orderDetail.htm',
       controller: 'OrderDetailController'
    }).

    when('/reporteordenes/:orderid', {
        templateUrl: 'orderReport.htm',
        controller: 'OrderReportController'
    }).

    otherwise({
       redirectTo: '/orders'
    });
 }]);