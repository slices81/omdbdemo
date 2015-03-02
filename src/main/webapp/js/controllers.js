'use strict';

/* Controllers */

var phonecatControllers = angular.module('phonecatControllers',  ['ui.bootstrap']);
/*phonecatControllers.controller('MovieSearchCtrl', ['$scope', function($scope) {
	}]);*/

phonecatControllers.controller('MovieSearchCtrl', function($scope, $routeParams, $location){
    $scope.search = function(){
        $location.url('/movies/' + $scope.movieTitle);
    };
});

phonecatControllers.controller('PhoneListCtrl', ['$scope', '$log', '$routeParams', 'Phone', function($scope, $log, $routeParams, Phone) {
	  $scope.phones = Phone.query({Name: $routeParams.movieTitle},{});
	  $scope.orderProp = 'age';
	  $scope.totalItems = 64;
	  $scope.currentPage = 4;

	  $scope.setPage = function (pageNo) {
	    $scope.currentPage = pageNo;
	  };

	  $scope.pageChanged = function() {
	    $log.log('Page changed to: ' + $scope.currentPage);
	  };

	  $scope.maxSize = 5;
	  $scope.bigTotalItems = 175;
	  $scope.bigCurrentPage = 1;
	}]);

/*
phonecatControllers.controller('PhoneDetailCtrl', ['$scope', '$routeParams',
                                                   function($scope, $routeParams) {
                                                     $scope.imdbID = $routeParams.imdbID;

                                                   }]);
*/

phonecatControllers.controller('PhoneDetailCtrl', ['$scope', '$routeParams', 'Movie', function($scope, $routeParams, Movie) {
	  $scope.movie = Movie.get({imdbID: $routeParams.imdbID},{});
	  $scope.rate = 7;
	  $scope.max = 10;
	  $scope.isReadonly = false;
	/*  $scope.setImage = function(imageUrl) {
	    $scope.mainImageUrl = imageUrl;
	  }*/
	}]);