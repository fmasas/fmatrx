 
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
    
    otherwise({
       redirectTo: '/orders'
    });
 }]);