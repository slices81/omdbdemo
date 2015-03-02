var phonecatServices = angular.module('phonecatServices', ['ngResource']);

phonecatServices.factory('Phone', ['$resource',
  function($resource){
    return $resource('api/v1/search?Name=X-Men', {}, {
      query: {method:'GET', params:{}, isArray:true}
    });
  }]);


phonecatServices.factory('Movie', ['$resource',
                                   function($resource){
                                     return $resource('api/v1/movie/tt1270798', {}, {
                                       query: {method:'GET', params:{}, isArray:true}
                                     });
                                   }]);