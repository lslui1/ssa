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
            console.log("SUBJECT LOG LOOPING")
            console.log(self.subjectarray)
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