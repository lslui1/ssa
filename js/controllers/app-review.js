angular
  .module("myApp")
  .controller("ReviewCtrl", ReviewCtrl)

  ReviewCtrl.$inject = ['$http', '$window','$scope','$routeParams']
  function ReviewCtrl($http, $window, $scope, $routeParams) {
  var self = this
  self.currentClassId = $routeParams.reviewClassId;


  self.showClassName = sessionStorage.reviewClassName
  self.showClassSection = sessionStorage.reviewClassSection
  self.showClassFname = sessionStorage.reviewClassFname
  self.showClassLname = sessionStorage.reviewClassLname

  $http.get('http://localhost:8080/Review/' + self.currentClassId)
      			.then(function(resp){
        			self.reviews = resp.data;
        		},function(err) {

        		});






}
