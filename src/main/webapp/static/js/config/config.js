
var config_module = angular.module('myApp.config', [])
.constant('ENV', {
  'name': 'development',
  'apiEndpoint': 'http://localhost:8080/FmaTransaccional2'
});