angular
  .module("myApp")
  .controller("ClassCtrl", ClassCtrl)

  ClassCtrl.$inject = ['$http', '$window','$scope']
  function ClassCtrl($http, $window, $scope) {
  var self = this



  $http.get('http://localhost:8080/professors')
      			.then(function(resp){
        			self.professors = resp.data;
        		},function(err) {

        		});


  $http.get('http://localhost:8080/classes')
  			.then(function(resp){
  				self.classes = resp.data;
          angular.forEach(self.classes, function(key, value) {
            self.classes.prof = self.professors;
          })
          console.log(self.classes)
  			},function(err) {

  			});

        $http.get('http://localhost:8080/combinedclasses')
            			.then(function(resp){
              			self.combinedclasses = resp.data;
              		},function(err) {

              		});



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
        $window.location.href = '/#/submitted';
      }, function(err) {
        console.log("FAILURE: " + resp)
      });
  }

}
