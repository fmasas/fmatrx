
App.controller('OrderController', ['$scope', '$location', 'OrderService', function($scope, $location, OrderService) {
          var self = this;
          self.order={id_order:null,clientname:'',order_date:'',deliver_date:'',order_total_value:'',order_status:''};
          self.orders=[];
          //self.client=[];
          self.client = ["Manuel Garcia", "Roberto Gomez", "Villapinzon", "Hector Segura", "Boyaca", "Alfonso Camargo", 
        	  "Oswaldo Pava", "Nelson Vargas", "Fernando Gonzalez", "Arcillas dorado", "Dimacut", "Industrias anda", 
        	  "Industrias renacer", "Inversiones lyar", "Ladrillera gresqui", "Ladrillera San Jose", "Ladrillera San Sebastian p1",
        	  "Ladrillera San Sebastian p2", "Ladrillera Tikal", "German Londono", "Gredil Gres", "Luis Murillo"];
          self.clientname = ["Manuel Garcia", "Roberto Gomez", "Villapinzon", "Hector Segura", "Boyaca", "Alfonso Camargo", 
        	  "Oswaldo Pava", "Nelson Vargas", "Fernando Gonzalez", "Arcillas dorado", "Dimacut", "Industrias anda", 
        	  "Industrias renacer", "Inversiones lyar", "Ladrillera gresqui", "Ladrillera San Jose", "Ladrillera San Sebastian p1",
        	  "Ladrillera San Sebastian p2", "Ladrillera Tikal", "German Londono", "Gredil Gres", "Luis Murillo"];
          self.client.sort();
          self.clientname.sort();
          self.order_status = ["Sin iniciar", "En proceso", "Terminado", "Entregado"];
          self.material = ["Maleable Acero 10-20", "Manganeso", "Manganeso Duro", "Cromo"];
          self.tmpOrderDate;
          self.tmpDeliverDate;
               
          /*self.fetchClients = function(){
              OrderService.fetchClients()
                  .then(
                               function(d) {
                                    self.client = d.content;
                               },
                                function(errResponse){
                                    console.error('Error while fetching Orders');
                                }
                       );
          };*/
          
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
          //self.fetchClients();
 
          self.submit = function() {
        	  var strdate = self.tmpOrderDate;
        	  var day = strdate.substring(0,2);
        	  var month = strdate.substring(3,5);
        	  var year = strdate.substring(6,10);
        	  self.order.order_date = (new Date(month+'-'+day+'-'+year)).getTime();
        	  strdate = '';
        	  strdate = self.tmpDeliverDate;
        	  var day = strdate.substring(0,2);
        	  var month = strdate.substring(3,5);
        	  var year = strdate.substring(6,10);
        	  self.order.deliver_date = (new Date(month+'-'+day+'-'+year)).getTime();
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
                     var todate = new Date(self.order.order_date).getDate();
                     if(todate < 10){
                    	 todate = '0' + todate;
                     }
                     var tomonth = new Date(self.order.order_date).getMonth()+1;
                     if(tomonth < 10){
                    	 tomonth = '0' + tomonth;
                     }
                     var toyear=new Date(self.order.order_date).getFullYear();
                     self.tmpOrderDate = todate+'-'+tomonth+'-'+toyear;
                     todate = '';
                     tomonth = '';
                     toyear = '';
                     todate = new Date(self.order.deliver_date).getDate();
                     if(todate < 10){
                    	 todate = '0' + todate;
                     }
                     var tomonth = new Date(self.order.deliver_date).getMonth()+1;
                     if(tomonth < 10){
                    	 tomonth = '0' + tomonth;
                     }
                     var toyear=new Date(self.order.deliver_date).getFullYear();
                     self.tmpDeliverDate = todate+'-'+tomonth+'-'+toyear;
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
              self.tmpOrderDate = '';
              self.tmpDeliverDate = '';
              $scope.myForm.$setPristine(); //reset Form
          };
          
          self.getPdf = function(id_order){
        	  console.log('controller download pdf');
              OrderService.getReport(id_order)
              .then(
                           function(data) {
                        	   var file = new Blob([data], {type: 'application/pdf'});
                        	   var fileURL = URL.createObjectURL(file);
                        	   window.open(fileURL);
                           },
                            function(errResponse){
                                console.error('Error while generating the repott ');
                            }
                   );
          };
          
          self.getFullReport = function(){
        	  console.log('controller download report');
              OrderService.getFullReport()
              .then(
                           function(data) {
                        	   var file = new Blob([data], {type: 'text/plain'});
                        	   var fileURL = URL.createObjectURL(file);
                        	   var downloadLink = angular.element('<a></a>');
                        	   downloadLink.attr('href',fileURL);
                        	   downloadLink.attr('target','_self');
                        	   downloadLink.attr('download', 'detail.csv');
                        	   downloadLink[0].click();
                           },
                            function(errResponse){
                                console.error('Error while generating the repott ');
                            }
                   );
          };
          
          
 
      }]);




