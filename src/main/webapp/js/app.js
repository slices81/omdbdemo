'use strict';

/* App Module */

var phonecatApp = angular.module('phonecatApp', [
  'ngRoute',
  'phonecatControllers',
  'phonecatServices'
]);

phonecatApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/phones', {
        templateUrl: 'partials/phone-list.html',
        controller: 'PhoneListCtrl'
      }).
      when('/movie/:imdbID', {
        templateUrl: 'partials/phone-details.html',
        controller: 'PhoneListCtrl'
      }).
      otherwise({
        redirectTo: '/phonesxxx'
      });
  }]);