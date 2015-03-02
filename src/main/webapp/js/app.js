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
    when('/search', {
        templateUrl: 'partials/movie-search.html',
        controller: 'MovieSearchCtrl'
      }).when('/movies', {
        templateUrl: 'partials/phone-list.html',
        controller: 'PhoneListCtrl'
      }).
      when('/movie/:imdbID', {
        templateUrl: 'partials/phone-details.html',
        controller: 'PhoneDetailCtrl'
      }).
      otherwise({
        redirectTo: '/search'
      });
  }]);