//var api_service = 'http://localhost:8080/FmaTransaccional2';
var api_service = 'http://vps-b05032bc.vps.ovh.ca:8080/FmaTransaccional';
//var api_client = 'http://localhost:8086/apiclient/client/';
var api_client = 'http://167.114.152.77:8090/apiclient/client/';

App.factory('OrderService', ['$http', '$q', function($http, $q){
 
    return {
           
    	   fetchClients: function() {
                 return $http.get(api_client)
                    .then(
                            function(response){
                            	console.log('Mensaje de angular');
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Error while fetching people');
                                return $q.reject(errResponse);
                            }
                    );
            },
    	
         
            fetchAllOrders: function() {
                    return $http.get(api_service+'/order/')
                            .then(
                                    function(response){
                                    	console.log('Mensaje de angular');
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching orders');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            fetchAllOrderItems: function(id_order) {
                return $http.get(api_service+'/orderitems/'+id_order)
                .then(
                        function(response){
                        	console.log('Retornado ',response );
                            return response.data;
                        }, 
                        function(errResponse){
                            console.error('Error while fetching orders');
                            return $q.reject(errResponse);
                        }
                );
            },
             
            createOrder: function(order){
                    return $http.post(api_service+'/order/', order)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating order');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            createOrderItem: function(orderItem){
                return $http.post(api_service+'/orderitems/', orderItem)
                        .then(
                        		function(response){
                        			console.log('Trying create order',orderItem);
                        			return response.data;
                                }, 
                                function(errResponse){
                                    console.error('Error while creating order');
                                    return $q.reject(errResponse);
                                }
                        );
            },            
             
            updateOrder: function(order, id_order){
                    return $http.put(api_service+'/order/'+id_order, order)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating order');
                                        return $q.reject(errResponse);
                                    }
                            );
            },

            updateOrderItem: function(orderItem, id_order_item){
                return $http.put(api_service+'/orderitems/'+id_order_item, orderItem)
                        .then(
                                function(response){
                                	console.log("Response", response);
                                    return response.data;
                                }, 
                                function(errResponse){
                                    console.error('Error while updating order Item');
                                    return $q.reject(errResponse);
                                }
                        );
           },
           
           getReport: function(orderid) {
        	   
               return $http.get(api_service+'/orderreport/'+orderid,  {responseType: 'arraybuffer'})
                       .then(
                               function(response){
                               	console.log('orderreport success');
                                   return response.data;
                               }, 
                               function(errResponse){
                                   console.error('Error while consuming report');
                                   return $q.reject(errResponse);
                               }
                       );
           },
           
           getFullReport: function(){
        	   
        	   return $http.get(api_service+'/detailedorders/', {responseType:'arraybuffer'})
        	           .then(
        	        		   function(response){
        	        			   console.log('Report generated succesfully');
        	        			   return response.data;
        	        		   },
        	        		   function(errResponse){
        	        			   console.error('Error while generating the report');
        	        			   return $q.reject(errResponse);
        	        		   }
        	           );
           },
            
           deleteOrder: function(id_order){
                    return $http.delete(api_service+'/order/'+id_order)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting order');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
    };
 
}]);