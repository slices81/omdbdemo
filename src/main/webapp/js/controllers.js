'use strict';

/* Controllers */

var phonecatControllers = angular.module('phonecatControllers', []);

phonecatControllers.controller('PhoneListCtrl', ['$scope', 'Phone', function($scope, Phone) {
	  $scope.phones = Phone.query();
	  $scope.orderProp = 'age';
	}]);

phonecatControllers.controller('PhoneDetailCtrl', ['$scope', 'Movie', function($scope, Movie) {
	alert('In detail comntroll');
	//$scope.movie = Movie.get();

	}]);