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

    self.Reviewclassreview = sessionStorage.Reviewclassreview
    self.Reviewprofessorreview = sessionStorage.Reviewprofreview
    self.ReviewloginId = sessionStorage.globaluserid
    self.Reviewingclassid = sessionStorage.reviewClassId
    self.Reviewreviewdate = sessionStorage.Reviewreviewdate
    self.Reviewyear = sessionStorage.Reviewyear
    self.Reviewsemester = sessionStorage.Reviewsemester
    self.Reviewclassrating = sessionStorage.Reviewclassrating
    self.Reviewprofessorrating = sessionStorage.Reviewprofrating

$scope.date = new Date();

}
