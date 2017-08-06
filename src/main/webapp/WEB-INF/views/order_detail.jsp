<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <script src="<c:url value='/static/js/config/config.js' />"></script>    
    <title>FMA Transaccional</title>  
    <style>
      .clientname.ng-valid {
          background-color: lightgreen;
      }
      .clientname.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .clientname.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }
 
      .quantity.ng-valid {
          background-color: lightgreen;
      }
      .quantity.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .quantity.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }
 
    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="OrderController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">FMA SAS - Area Transaccional - Registro de ordenes </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.order.id" />
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="id_order">Num. Orden</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.order.id_order" id="id_order" class="form-control input-sm" placeholder="Ingrese el número de la orden"/>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="clientname">Cliente</label>
                              <div class="col-md-7">
                                  <select ng-model="ctrl.order.clientname" id="clientname" ng-options="x for x in ctrl.cliente" class="clientname form-control input-sm" placeholder="Ingrese el nombre del cliente" required ng-minlength="3"></select>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.clientname.$error.required">Este es un campo requerido</span>
                                      <span ng-show="myForm.clientname.$error.minlength">Longitud minima requerida es 3</span>
                                      <span ng-show="myForm.clientname.$invalid">Este campo es invalido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                       
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="product">Producto</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.order.product" id="product" class="form-control input-sm" placeholder="Ingrese la descripcion del producto ordenado"/>
                              </div>
                          </div>
                      </div>
 
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="material_type">Tipo de material</label>
                              <div class="col-md-7">
                                  <select ng-model="ctrl.order.material_type" id="material_type" ng-options="x for x in ctrl.material" class="form-control input-sm"></select>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="quantity">Cantidad</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.order.quantity" id="quantity" class="quantity form-control input-sm" placeholder="Ingrese la cantidad" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.quantity.$error.required">Este es un campo requerido</span>
                                      <span ng-show="myForm.quantity.$invalid">Este campo es invalido  </span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="unity_weight">Peso unidad</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.order.unity_weight" id="unity_weight" class="form-control input-sm" placeholder="Ingrese el peso por unidad unitario"/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="unity_value">Valor unidad</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.order.unity_value" id="unity_value" class="form-control input-sm" placeholder="Ingrese el valor por unidad unitario"/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="order_date">Fecha Orden</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.order.order_date" data-date-format="yyyy-mm-dd" value="{{ctrl.order.order_date | date:yyyy-mm-dd}}" id="order_date" class="form-control input-sm" placeholder="Ingrese fecha de la orden (yyyy-mm-dd)"/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="deliver_date">Fecha Entrega</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.order.deliver_date" id="deliver_date" class="form-control input-sm" placeholder="Ingrese fecha de la entrega (yyyy-mm-dd)"/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="order_status">Estado Orden</label>
                              <div class="col-md-7">
                                  <select ng-model="ctrl.order.order_status" id="order_status" ng-options="x for x in ctrl.order_status" class="form-control input-sm"></select>
                              </div>
                          </div>
                      </div>

 
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.order.id ? 'Agregar' : 'Editar'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Limpiar formulario</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">Lista de Ordenes </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Orden</th>
                              <th>Cliente</th>
                              <th>Producto</th>
                              <th>Tipo de material</th>
                              <th>Cantidad</th>
                              <th>Peso unidad</th>
                              <th>Peso total</th>
                              <th>Valor unidad</th>
                              <th>Valor total</th>
                              <th>Fecha orden</th>
                              <th>Fecha entrega</th>
                              <th>Estado orden</th>                              
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.orders">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.id_order"></span></td>
                              <td><span ng-bind="u.clientname"></span></td>
                              <td><span ng-bind="u.product"></span></td>
                              <td><span ng-bind="u.material_type"></span></td>
                              <td><span ng-bind="u.quantity"></span></td>
                              <td><span ng-bind="u.unity_weight"></span></td>
                              <td><span ng-bind="u.total_weight"></span></td>
                              <td><span ng-bind="u.unity_value"></span></td>
                              <td><span ng-bind="u.total_value"></span></td>
                              <td><span ng-bind="u.order_date"></span></td>
                              <td><span ng-bind="u.deliver_date"></span></td>
                              <td><span ng-bind="u.order_status"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Editar</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remover</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
       
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/order_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/order_controller.js' />"></script>
  </body>
</html>