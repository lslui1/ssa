angular
  .module("myApp")
  .controller("LogoutCtrl", LogoutCtrl)
  LogoutCtrl.$inject = ['$window']
  function LogoutCtrl($window) {

    var self = this;

    self.globalusername = sessionStorage.globalusername;

  self.loggingOut = function() {
    var r = confirm("Are you sure you want to log out?");
    if(r==true) {
      // console.log("confirmed logout")
      sessionStorage.clear();
        $window.location.href = '#/';
    } else {
      // console.log("canceled logout")
    }

}
}
