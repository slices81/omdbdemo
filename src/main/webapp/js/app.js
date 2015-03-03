'use strict';

/* App Module */

var phonecatApp = angular.module('movieApp', [
  'ngRoute',
  'movieControllers',
  'phonecatServices'
]);

phonecatApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
    when('/search', {
        templateUrl: 'partials/movie-search.html',
        controller: 'MovieSearchCtrl'
      }).when('/movies/:movieTitle', {
        templateUrl: 'partials/movie-list.html',
        controller: 'PhoneListCtrl'
      }).
      when('/movie/:imdbID', {
        templateUrl: 'partials/movie-details.html',
        controller: 'PhoneDetailCtrl'
      }).
      otherwise({
        redirectTo: '/search'
      });
  }]);