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


$http.get('http://localhost:8080/savedclasses/' + self.loginid)
      .then(function(resp){
        self.myclasses = resp.data;
        
      },function(err) {

      });



  self.reverseList = function() {
    self.combinedclasses.reverse()
  }

  $http.get('http://localhost:8080/professors')
      			.then(function(resp){
        			self.professors = resp.data;
        		},function(err) {

        		});


            $http.get('http://localhost:8080/classesbyprof/' + self.pathprofid)
                      .then(function(resp){
                        self.profclasses = resp.data;
                      },function(err) {

                      });


  $http.get('http://localhost:8080/classes')
  			.then(function(resp){
  				self.classes = resp.data;
          // angular.forEach(self.classes, function(key, value) {
          //   self.classes.prof = self.professors;
          // })
          // console.log(self.classes)
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

}
