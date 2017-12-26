App.controller('OrderReportController', ['$scope', '$routeParams', '$route', 'OrderService', function($scope, $routeParams, $route, OrderService) {
	var selfRep = this;
    var orderid = $routeParams.orderid;
    
    console.log(orderid);
	
}]);