'use strict';

/* Controllers */

var phonecatControllers = angular.module('phonecatControllers', []);
/*phonecatControllers.controller('MovieSearchCtrl', ['$scope', function($scope) {
	}]);*/

phonecatControllers.controller('MovieSearchCtrl', function($scope, $routeParams, $location){
    $scope.search = function(){
        $location.url('/movies/' + $scope.movieTitle);
    };
});

phonecatControllers.controller('PhoneListCtrl', ['$scope',  '$routeParams', 'Phone', function($scope, $routeParams, Phone) {
	  $scope.phones = Phone.query({Name: $routeParams.movieTitle},{});
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