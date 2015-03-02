'use strict';

/* Controllers */

var phonecatControllers = angular.module('phonecatControllers', []);
phonecatControllers.controller('MovieSearchCtrl', ['$scope', function($scope) {
	}]);

phonecatControllers.controller('PhoneListCtrl', ['$scope', 'Phone', function($scope, Phone) {
	  $scope.phones = Phone.query();
	  $scope.orderProp = 'age';
	}]);

/*
phonecatControllers.controller('PhoneDetailCtrl', ['$scope', '$routeParams',
                                                   function($scope, $routeParams) {
                                                     $scope.imdbID = $routeParams.imdbID;

                                                   }]);
*/

phonecatControllers.controller('PhoneDetailCtrl', ['$scope', '$routeParams', 'Movie', function($scope, $routeParams, Movie) {
	  $scope.movie = Movie.get({imdbID: $routeParams.imdbID},{});

	/*  $scope.setImage = function(imageUrl) {
	    $scope.mainImageUrl = imageUrl;
	  }*/
	}]);