angular
  .module("myApp")
  .controller("SubmittedCtrl", SubmittedCtrl)

  SubmittedCtrl.$inject = ['$window','$scope']
  function SubmittedCtrl($window, $scope) {
  var self = this

    self.Classsubject = sessionStorage.name
    self.Classsubjectsection = sessionStorage.section
    self.Classsubjectprofessor_id = sessionStorage.professor_id
    self.Classsubjectuniversity_id = sessionStorage.university_id

    self.Professorfirstname = sessionStorage.firstname
    self.Professorlastname = sessionStorage.lastname
    self.Professoruid = sessionStorage.uid




}
