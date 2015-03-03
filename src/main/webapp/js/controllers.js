'use strict';

/* Controllers */

var movieControllers = angular.module('movieControllers',  ['ui.bootstrap']);
/*phonecatControllers.controller('MovieSearchCtrl', ['$scope', function($scope) {
	}]);*/

movieControllers.controller('MovieSearchCtrl', function($scope, $routeParams, $location){
    $scope.search = function(){
        $location.url('/movies/' + $scope.movieTitle);
    };
});

movieControllers.controller('PhoneListCtrl', ['$scope', '$log', '$routeParams', 'Phone', function($scope, $log, $routeParams, Phone) {
	  $scope.phones = Phone.query({Name: $routeParams.movieTitle},{});
	  $scope.itemsPerPage = 5
	  $scope.currentPage = 1;

	  $scope.pageCount = function () {
	    return Math.ceil($scope.phones.length / $scope.itemsPerPage);
	  };

	  $scope.phones.$promise.then(function () {
	    $scope.totalItems = $scope.phones.length;
	    $scope.$watch('currentPage + itemsPerPage', function() {
	      var begin = (($scope.currentPage - 1) * $scope.itemsPerPage),
	        end = begin + $scope.itemsPerPage;

	      $scope.filteredPhones = $scope.phones.slice(begin, end);
	    });
	  });
	
	}]);

/*
phonecatControllers.controller('PhoneDetailCtrl', ['$scope', '$routeParams',
                                                   function($scope, $routeParams) {
                                                     $scope.imdbID = $routeParams.imdbID;

                                                   }]);
*/

movieControllers.controller('PhoneDetailCtrl', ['$scope', '$routeParams', 'Movie', function($scope, $routeParams, Movie) {
	  $scope.movie = Movie.get({imdbID: $routeParams.imdbID},{});
	  $scope.rate = Math.floor($scope.movie.imdbRating);
	  $scope.max = 11;
	  $scope.isReadonly = true;
	/*  $scope.setImage = function(imageUrl) {
	    $scope.mainImageUrl = imageUrl;
	  }*/
	}]);