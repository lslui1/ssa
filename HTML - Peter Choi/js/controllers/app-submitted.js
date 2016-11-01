angular
  .module("myApp")
  .controller("SubmittedCtrl", SubmittedCtrl)

SubmittedCtrl.$inject = ['$window','$scope', '$location', '$timeout']
 function SubmittedCtrl($window, $scope, $location, $timeout) {
 var self = this

 $timeout(function() {
      if (sessionStorage.returnstate == 'classes') {
          console.log("Going to " + sessionStorage.returnstate)
        $window.location.href = '/#/classes';
      }
      if (sessionStorage.returnstate == 'editmyreview') {
          console.log("Going to " + sessionStorage.returnstate)
        $window.location.href = '/#/myreviews';
      }
      if (sessionStorage.returnstate == 'addreview') {
          console.log("Going to " + sessionStorage.returnstate)
        $window.location.href = '/#/myreviews';
      }
      if (sessionStorage.returnstate == 'addprofessor') {
          console.log("Going to " + sessionStorage.returnstate)
        $window.location.href = '/#/professors';
      }
   }, 3000);

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
