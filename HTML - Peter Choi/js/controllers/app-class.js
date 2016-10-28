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
self.useAlternativeSavedClassId = sessionStorage.alternativeSavedClassId

self.profClassId = sessionStorage.professor_id

self.showProfessorTable = false;


// self.addReviewClassName = sessionStorage.addReviewClassName
// self.addReviewClassSection = sessionStorage.addReviewClassSection
// self.addReviewProfFname = sessionStorage.addReviewProfFname
// self.addReviewProfLname = sessionStorage.addReviewProfLname







self.subjectarray = [];
self.profsubjectarray = [];

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
            $http.get('http://localhost:8080/combinedclassbyprofessorid/' + self.pathprofid)
                      .then(function(resp){
                        self.profclasses = resp.data;
                      },function(err) {

                      })};



    if(self.pathprofid != undefined) {
                $http.get('http://localhost:8080/ReviewsByProfessor/' + self.pathprofid)
                          .then(function(resp){
                            self.profreview = resp.data;
                            console.log("hi")
                            console.log(self.profreview)
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


        $http.get('http://localhost:8080/combinedclassbyprofessorid/' + self.profClassId)
        			.then(function(resp){
        				self.classes = resp.data;
                self.profsubjectarray.push("");
                self.profselectedOption = self.profsubjectarray[2];
                angular.forEach(resp.data, function(value, key){
                  // console.log("SUBJECT LOG LOOPING")
                  // console.log(self.subjectarray)
                     if(self.profsubjectarray.indexOf(value.name) == -1) {
                        self.profsubjectarray.push(value.name)
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
  console.log("testing function click")
  console.log(classId)
  console.log(sessionStorage.reviewClassId)
}

self.getClassIdForAlternativeClasses = function(classId, savedClassId) {
  sessionStorage.setItem("alternativeClassId", classId)
  sessionStorage.setItem("alternativeSavedClassId", savedClassId)
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
                          },function(err) {
                          })

  			$http.get('http://localhost:8080/savedclassbyloginclassid/' + self.loginid + '/' + self.useAlternativeClassId)
                          .then(function(resp){
                            self.alternativecompareclass = resp.data;
                          },function(err) {
                          })

  	};


  self.replaceMySavedClass = function(loginId, newClassId) {
  var replacetheseclasses = {};
  replacetheseclasses.login_id = loginId;
  replacetheseclasses.newclass_id = newClassId;
  replacetheseclasses.oldclass_id = self.useAlternativeSavedClassId;
  console.log(replacetheseclasses)


  self.deletesavedclass(replacetheseclasses.oldclass_id)
  self.addToMySavedClasses(loginId, newClassId)
  $window.location.href = '#/myclasses';
}


  self.populate = function(firstName, lastName) {
          self.professor_fname = firstName;
          self.professor_lname = lastName;
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
          var fname = self.professor_fname;
          var lname = self.professor_lname;
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
    sessionStorage.setItem("returnstate", "classes");
    $window.location.href = '/#/submittedclass';
})
}



self.cantFindProfessor = function() {
         document.getElementById("professor_fname").disabled = false;
         document.getElementById("professor_lname").disabled = false;
        document.getElementById("professor_fname").style.backgroundColor = '#b8d1f3';
        document.getElementById("professor_lname").style.backgroundColor = '#b8d1f3';
}


self.saveClassProfNames = function(classId,className,classSection,profFname, profLname) {
    sessionStorage.setItem("reviewClassId", classId);
    sessionStorage.setItem("reviewClassName", className);
    sessionStorage.setItem("reviewClassSection", classSection);
    sessionStorage.setItem("reviewClassFname", profFname);
    sessionStorage.setItem("reviewClassLname", profLname);

}


//Sort Methods//

var sortSubject = false;
self.sortSubject = function() {
  if (sortSubject == false) {
    sortType = ['name', 'section'];
    sortSubject = true;
  }
  else {
    sortType = ['-name', 'section'];
    sortSubject = false;
  }
  return sortType
}

var sortName = false;
self.sortName = function() {
  if (sortName == false) {
    sortType = ['professor_lname', 'professor_fname'];
    sortName = true;
  }
  else {
    sortType = ['-professor_lname', 'professor_fname'];
    sortName = false;
  }
  return sortType
}

var sort1CR = false;
self.sort1CR = function() {
  if (sort1CR == false) {
    sortType = '-aggregateClassRating';
    sort1CR = true;
  }
  else {
    sortType = 'aggregateClassRating';
    sort1CR = false;
  }
  return sortType
}

var sort1PR = false;
self.sort1PR = function() {
  if (sort1PR == false) {
    sortType = '-aggregateProfessorRating';
    sort1PR = true;
  }
  else {
    sortType = 'aggregateProfessorRating';
    sort1PR = false;
  }
  return sortType
}

var sortCount = false;
self.sortCount = function() {
  if (sortCount == false) {
    sortType = '-aggregateCount';
    sortCount = true;
  }
  else {
    sortType = 'aggregateCount';
    sortCount = false;
  }
  return sortType
}

var sortYOR = false;
self.sortYOR = function() {
  if (sortYOR== false) {
    sortType = '-review_date';
    sortYOR = true;
  }
  else {
    sortType = 'review_date';
    sortYOR = false;
  }
  return sortType
}

var sortYear = false;
self.sortYear = function() {
  if (sortYear == false) {
    sortType = ['-year', 'semester'];
    sortYear = true;
  }
  else {
    sortType = ['year', 'semester'];
    sortYear = false;
  }
  return sortType
}

var sortCR2 = false;
self.sortCR2 = function() {
  if (sortCR2 == false) {
    sortType = '-class_rating';
    sortCR2 = true;
  }
  else {
    sortType = 'class_rating';
    sortCR2 = false;
  }
  return sortType
}

var sortPR2 = false;
self.sortPR2 = function() {
  if (sortPR2 == false) {
    sortType = '-professor_rating';
    sortPR2 = true;
  }
  else {
    sortType = 'professor_rating';
    sortPR2 = false;
  }
  return sortType
}

var sortSection = false;
self.sortSection = function() {
  if (sortSection == false) {
    sortType = '-section';
    sortSection = true;
  }
  else {
    sortType = 'section';
    sortSection = false;
  }
  return sortType
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
