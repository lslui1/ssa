angular
  .module("myApp")
  .controller("LoginCtrl", LoginCtrl)

  LoginCtrl.$inject = ["$http"]

  function LoginCtrl($http) {

    var self = this;

  self.getLogin = function(username, pass) {
    var login = {};
    // login.id = 1000;
    login.user_name = username;
    console.log(username)
    login.password = pass;
    console.log(pass)
    // console.log(login)
    $http({
        method: "POST",
        url: 'http://localhost:8080/login/',
        data: login
      })
  			.then(function(resp) {
  				console.log("SUCCESS: " + resp)
          $window.open("http://localhost:8080/")

  			},function(err) {
          console.log("FAILURE: " + resp)
  			});
}
}
