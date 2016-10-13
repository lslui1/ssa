angular
  .module("myApp")
  .controller("AppCtrl", AppCtrl)

  AppCtrl.$inject = ["Items"]
  function AppCtrl(Items) {
  var self = this
}
