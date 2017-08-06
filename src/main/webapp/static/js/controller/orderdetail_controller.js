App.controller('OrderDetailController', ['$scope', '$routeParams', '$route', 'OrderService', function($scope, $routeParams, $route, OrderService) {
    var selfDet = this;
    var param1 = $routeParams.param1;
    selfDet.orderDet={id_order:null,id_order_item:null,product:null,order_item_status:null};    
    selfDet.ordersDet=[];
    selfDet.order_item_status = ["Sin iniciar", "En proceso", "Terminado", "Entregado"];
    selfDet.material = ["Blandito", "Medio", "Duro", "Cromo", "Manganeso", "Maquinable"];
	console.log('Controller OrderDetailController loaded');
	selfDet.orderDet.id_order = param1;
    $scope.message = "This page will be used to display all the students";
    console.log(param1);
    
    selfDet.fetchAllDetailOrders = function(id_order){
    	console.log('fetchAllOrderItems loaded with id_order ' + id_order);
        OrderService.fetchAllOrderItems(id_order)
        .then(
                     function(d) {
                    	 selfDet.ordersDet = d;
                     },
                      function(errResponse){
                          console.error('Error while fetching Orders');
                      }
             );
    };
    
    selfDet.createOrderDet = function(orderDet){
    	console.log('createOrderDet: ', orderDet);
    	console.log('param1: ', param1);
    	OrderService.createOrderItem(orderDet)
                .then(
                selfDet.fetchAllDetailOrders(param1), 
                        function(errResponse){
                             console.error('Error while creating Order Detail.');
                        } 
            );
    };    
    
    selfDet.fetchAllDetailOrders(param1);
    
    selfDet.updateOrderItem = function(orderDet, id_order_item){
        OrderService.updateOrderItem(orderDet, id_order_item)
                .then(
                		selfDet.fetchAllDetailOrders(param1), 
                        function(errResponse){
                             console.error('Error while updating Order.');
                        }
            );
    };
    
    selfDet.submit = function() {
        if(selfDet.orderDet.id_order_item===null){
            console.log('Saving New Order', selfDet.orderDet);    
            selfDet.createOrderDet(selfDet.orderDet);
        }else{
        	console.log('Updating Order', selfDet.orderDet);
        	selfDet.updateOrderItem(selfDet.orderDet, selfDet.orderDet.id_order_item);
            console.log('OrderDet updated with id ', selfDet.orderDet.id_order_item);
        }
        selfDet.reset();
        selfDet.waittime();
        $route.reload();
    };
    
    selfDet.edit = function(id_order_item){
        console.log('id to be edited', id_order_item);
        for(var i = 0; i < selfDet.ordersDet.length; i++){
            if(selfDet.ordersDet[i].id_order_item === id_order_item) {
            	selfDet.orderDet = angular.copy(selfDet.ordersDet[i]);
               break;
            }
        }
    };
    
    selfDet.waittime = function(){
    	   console.log("Start waiting");
    	   for (var i=0; i<950000000; i++) {
    		      null;
    	   }
    	   console.log("End waiting");
    };
    
    selfDet.reset = function(){
        selfDet.orderDet={id_order:null,id_order_item:null,product:null,order_item_status:null};
        $scope.FormODet.$setPristine(); //reset Form
    };    
    
}]);
