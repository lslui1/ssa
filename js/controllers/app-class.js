angular
  .module("myApp")
  .controller("ClassCtrl", ClassCtrl)


  ClassCtrl.$inject = ['$http', '$window','$scope','$routeParams']
  function ClassCtrl($http, $window, $scope, $routeParams) {
  var self = this

self.pathprofid = $routeParams.pathingprofId;

self.loginid = sessionStorage.globaluserid;


self.PROFfname = sessionStorage.PROFESSORfname
self.PROFlname = sessionStorage.PROFESSORlname

self.useAlternativeClassId = sessionStorage.alternativeClassId

self.showProfessorTable = false;




self.subjectarray = [];

if(self.loginid != undefined) {
$http.get('http://localhost:8080/savedclasses/' + self.loginid)
      .then(function(resp){

        self.myclasses = resp.data;
        console.log(self.myclasses)
      },function(err) {

      })};



  self.reverseList = function() {
    self.combinedclasses.reverse()
  }

  $http.get('http://localhost:8080/professors')
      			.then(function(resp){
        			self.professors = resp.data;
        		},function(err) {

        		});


if(self.pathprofid != undefined) {
            $http.get('http://localhost:8080/classesbyprof/' + self.pathprofid)
                      .then(function(resp){
                        self.profclasses = resp.data;
                      },function(err) {

                      })};


  $http.get('http://localhost:8080/classes')
  			.then(function(resp){
  				self.classes = resp.data;
          self.subjectarray.push("");
          self.selectedOption = self.subjectarray[2];
          angular.forEach(resp.data, function(value, key){
            // console.log("SUBJECT LOG LOOPING")
            // console.log(self.subjectarray)
               if(self.subjectarray.indexOf(value.name) == -1) {
                  self.subjectarray.push(value.name)
                }
            });

  			},function(err) {

  			});

        $http.get('http://localhost:8080/combinedclasses')
            			.then(function(resp){
              			self.combinedclasses = resp.data;
              		},function(err) {

              		});


self.saveClassId = function(classId, className, classSection, classFname, classLname) {
  sessionStorage.setItem("reviewClassId", classId)
  sessionStorage.setItem("reviewClassName", className)
  sessionStorage.setItem("reviewClassSection", classSection)
  sessionStorage.setItem("reviewClassFname", classFname)
  sessionStorage.setItem("reviewClassLname", classLname)
}

self.getClassIdForAlternativeClasses = function(classId) {
  sessionStorage.setItem("alternativeClassId", classId)
}

self.addToMySavedClasses = function(loginId, classId) {
  var addtheseclasses = {};
  addtheseclasses.login_id = loginId;
  addtheseclasses.class_id = classId;
  console.log(addtheseclasses.login_id)
  console.log(addtheseclasses.class_id)

  $http({
    method: 'POST',
    url: 'http://localhost:8080/insertsavedclass',
    data: addtheseclasses
  })
    .then(function(resp) {
      console.log("SUCCESS: " + resp)
    }, function(err) {
      console.log("FAILURE: " + resp)
    });

}


self.deletesavedclass = function(savedclassid) {
  console.log(savedclassid)
  $http.get('http://localhost:8080/deletesavedclass/' + savedclassid)
        .then(function(resp){
          $window.location.reload();
        },function(err) {

        })
}

  self.addClass = function(subject, section, pid, uid) {
    var myClass = {};
    myClass.name = subject;
    myClass.section = section;
    myClass.professor_id = pid;
    myClass.university_id = uid;



    sessionStorage.setItem("name", subject);
    sessionStorage.setItem("section", section);
    sessionStorage.setItem("professor_id", pid);
    sessionStorage.setItem("university_id", uid);



    $http({
      method: 'POST',
      url: 'http://localhost:8080/addclass',
      data: myClass
    })
      .then(function(resp) {
        console.log("SUCCESS: " + resp)
        $window.location.href = '/#/submittedclass';
      }, function(err) {
        console.log("FAILURE: " + resp)
      });
  }

  if(self.useAlternativeClassId != undefined) {
              $http.get('http://localhost:8080/alternativeclassesbyclassid/' + self.useAlternativeClassId)
                        .then(function(resp){
                          self.alternativeclasses = resp.data;
                          console.log(self.alternativeclasses)
                        },function(err) {

                        })};


  self.populate = function(firstName, lastName) {
          document.getElementById("professor_fname").value = firstName;
          document.getElementById("professor_lname").value = lastName;
          document.getElementById("professor_fname").style.backgroundColor = 'lightgreen';
          document.getElementById("professor_lname").style.backgroundColor = 'lightgreen';
  }

  self.enableInput = function() {
        document.getElementById('professor_name').disabled = false;
        self.showProfessorTable = true;
  $http.get("http://localhost:8080/professors")
      .then(function(resp) {
        self.professors = resp.data;

        for (professor of self.professors) {
          professor.fullName = professor.first_name + " " + professor.last_name;
        }
        })
  	}

    self.addClassOrProf = function() {
          var fname = document.getElementById("professor_fname").value;
          var lname = document.getElementById("professor_lname").value;
          var url = "http://localhost:8080/professorbyfnamelname/" + fname + "/" + lname;
          var professorId = 0 ;
                $.ajax({
                url: url,
                type: "GET"
        }).then(function(resp){
          if (resp.length == 0) {
              var newProfessor = {};
              newProfessor.university_id = 1;
              newProfessor.first_name = fname;
              newProfessor.last_name = lname;
              $.ajax({
                headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
                },
                url: "http://localhost:8080/addprofessor",
                type: "POST",
                 data: JSON.stringify(newProfessor),
                 dataType: 'text'
             }).then(function() {
              var url = "http://localhost:8080/professorbyfnamelname/" + fname + "/" + lname;
                $.ajax({
                url: url,
                type: "GET"
                }).then(function(resp){
                      professorId = resp[0].id;
                      addFunction(professorId)})
            }
          )
    }
          else {
            var professorId = resp[0].id;
            addFunction(professorId);
          }
      })}


      function addFunction(professorId) {
  var newClass = {};
  var subject = document.getElementById("subject").value;
  var section = document.getElementById("section").value;
  newClass.university_id = 1;
  newClass.professor_id = professorId;
  newClass.name = subject;
  newClass.section = section;
  console.log(newClass)
  $.ajax({
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  },
    url: "http://localhost:8080/addclass",
    type: "POST",
    data: JSON.stringify(newClass),
    dataType: 'text'
}).then(function() {
  console.log("hi")
    $window.location.href = '/#/submittedclass';
})
}



self.cantFindProfessor = function() {
         document.getElementById("professor_fname").disabled = false;
         document.getElementById("professor_lname").disabled = false;
        document.getElementById("professor_fname").style.backgroundColor = '#b8d1f3';
        document.getElementById("professor_lname").style.backgroundColor = '#b8d1f3';
}


};


angular
  .module("myApp").directive('starRating', function () {
    return {
        restrict: 'A',
        template: '<ul class="rating">' +
            '<li ng-repeat="star in stars" ng-class="star">' +
            '\u2605' +
            '</li>' +
            '</ul>',
        scope: {
            ratingValue: '=',
            max: '='
        },
        link: function (scope, elem, attrs) {
            scope.stars = [];
            for (var i = 0; i < scope.max; i++) {
                scope.stars.push({
                    filled: i < (scope.ratingValue - 0.5)
                });
            }
        }
    }
});
