<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
   <head>
      <title>Gestión de Ordenes - FMA</title>
      <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
      <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular-route.min.js"></script>
      <script src="<c:url value='/static/js/expenses/app.js' />"></script>
      <script src="<c:url value='/static/js/expenses/service/expenses_service.js' />"></script>
      <script src="<c:url value='/static/js/expenses/controller/expenses_controller.js' />"></script>
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
   
   <body>
                Registro de gastos
   </body>
</html>   
