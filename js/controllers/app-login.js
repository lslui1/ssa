angular
  .module("myApp")
  .controller("AppCtrl", AppCtrl)

  AppCtrl.$inject = ["$http"]
  function getLogin() {
    $http.get('http://localhost:8080/login')
  			.then(function(resp){
  				self.login = resp.data;
  			},function(err) {

  			});  
}
