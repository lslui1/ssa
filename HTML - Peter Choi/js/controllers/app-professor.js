angular
  .module("myApp")
  .controller("ProfessorCtrl", ProfessorCtrl)

  ProfessorCtrl.$inject = ["$http", '$window']
  function ProfessorCtrl($http, $window) {
  var self = this

  $http.get('http://localhost:8080/combinedprofessors')
      			.then(function(resp){
        			self.professors = resp.data;
              for (professors of self.professors) {
                professors.fullnameofprof = professors.first_name + " " + professors.last_name;
              }
              console.log(self.professors)
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


            self.saveProfFnameLname = function(proffname, proflname, pid) {
              sessionStorage.setItem("PROFESSORfname", proffname)
              sessionStorage.setItem("PROFESSORlname", proflname)
              sessionStorage.setItem("reviewClassFname", proffname)
              sessionStorage.setItem("reviewClassLname", proflname)
              sessionStorage.setItem("professor_id", pid);
            }



            //Sort Methods

var sortName = false;
self.sortName = function() {
  if (sortName == false) {
    sortType = ['last_name', 'first_name'];
    sortName = true;
  }
  else {
    sortType = ['-last_name', 'first_name'];
    sortName = false;
  }
  return sortType
}

var sortPR = false;
self.sortPR = function() {
  if (sortPR == false) {
    sortType = '-aggregateProfRating';
    sortPR = true;
  }
  else {
    sortType = 'aggregateProfRating';
    sortPR = false;
  }
  return sortType
}

var sortCount = false;
self.sortCount = function() {
  if (sortCount == false) {
    sortType = '-count';
    sortCount = true;
  }
  else {
    sortType = 'count';
    sortCount = false;
  }
  return sortType
}


}
