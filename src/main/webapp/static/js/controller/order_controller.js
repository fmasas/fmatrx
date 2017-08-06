
App.controller('OrderController', ['$scope', '$location', 'OrderService', function($scope, $location, OrderService) {
          var self = this;
          self.order={id_order:null,clientname:'',order_date:'',deliver_date:'',order_total_value:'',order_status:''};
          self.orders=[];
          self.cliente = ["Manuel Garcia", "Roberto Gomez", "Villapinzon", "Hector Segura", "Boyaca", "Alfonso Camargo", "Oswaldo Pava"];
          self.order_status = ["Sin iniciar", "En proceso", "Terminado", "Entregado"];
          self.material = ["Maleable Acero 10-20", "Manganeso", "Manganeso Duro", "Cromo"];
               
          self.fetchAllOrders = function(){
              OrderService.fetchAllOrders()
                  .then(
                               function(d) {
                                    self.orders = d;
                               },
                                function(errResponse){
                                    console.error('Error while fetching Orders');
                                }
                       );
          };
            
          self.createOrder = function(order){
              OrderService.createOrder(order)
                      .then(
                      self.fetchAllOrders, 
                              function(errResponse){
                                   console.error('Error while creating Order.');
                              } 
                  );
          };
 
         self.updateOrder = function(order, id_order){
              OrderService.updateOrder(order, id_order)
                      .then(
                              self.fetchAllOrders, 
                              function(errResponse){
                                   console.error('Error while updating Order.');
                              } 
                  );
          };
 
         self.deleteOrder = function(id_order){
              OrderService.deleteOrder(id_order)
                      .then(
                              self.fetchAllOrders, 
                              function(errResponse){
                                   console.error('Error while deleting Order.');
                              } 
                  );
          };
 
          self.fetchAllOrders();
 
          self.submit = function() {
              if(self.order.id_order===null){
                  console.log('Saving New Order', self.order);    
                  self.createOrder(self.order);
              }else{
                  self.updateOrder(self.order, self.order.id_order);
                  console.log('Order updated with id ', self.order.id_order);
              }
              self.reset();
          };
               
          self.edit = function(id_order){
              console.log('id to be edited', id_order);
              for(var i = 0; i < self.orders.length; i++){
                  if(self.orders[i].id_order === id_order) {
                     self.order = angular.copy(self.orders[i]);
                     break;
                  }
              }
          };
               
          self.remove = function(id_order){
              console.log('id to be deleted', id_order);
              if(self.order.id_order === id_order) {//clean form if the order to be deleted is shown there.
                 self.reset();
              }
              self.deleteOrder(id_order);
          };
          
          self.goDetail = function(id_order){
              console.log('goView');
              $location.url('/orderDetail/'+id_order);
          };

          self.reset = function(){
              self.order={id_order:null,clientname:'',order_date:'',deliver_date:'',order_total_value:'',order_status:''};
              $scope.myForm.$setPristine(); //reset Form
          };
 
      }]);




