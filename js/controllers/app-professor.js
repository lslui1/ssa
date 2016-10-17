angular
  .module("myApp")
  .controller("ProfessorCtrl", ProfessorCtrl)

  ProfessorCtrl.$inject = ["$http", '$window']
  function ProfessorCtrl($http, $window) {
  var self = this

  $http.get('http://localhost:8080/professors')
      			.then(function(resp){
        			self.professors = resp.data;
        		},function(err) {

        		});


            self.addProfessor = function(firstname, lastname, uid) {
              var myProfessor = {};
              myProfessor.first_name = firstname;
              myProfessor.last_name = lastname;
              myProfessor.university_id = uid;

              sessionStorage.setItem("firstname", firstname);
              sessionStorage.setItem("lastname", lastname);
              sessionStorage.setItem("uid", uid);

              $http({
                method: 'POST',
                url: 'http://localhost:8080/addprofessor',
                data: myProfessor
              })
                .then(function(resp) {
                  console.log("SUCCESS: " + resp)
                  $window.location.href = '/#/submittedprofessor';
                }, function(err) {
                  console.log("FAILURE: " + resp)
                });
            }


}
