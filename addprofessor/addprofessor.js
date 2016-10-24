angular.module("AppMod", ["ngRoute"])
	.controller("AppCtrl", ['$http', '$routeParams', function($http, $routeParams) {
		var self = this;




		self.enableInput = function() {
      document.getElementById('professor_name').disabled = false;
$http.get("http://localhost:8080/professors")
    .then(function(resp) {
      self.professors = resp.data;
      for (professor of self.professors) {
        professor.fullName = professor.first_name + " " + professor.last_name;
      }
      })
	}


    self.populate = function(firstName, lastName) {
         document.getElementById("professor_fname").value = firstName;
         document.getElementById("professor_lname").value = lastName;
        document.getElementById("professor_fname").style.backgroundColor = 'lightgreen';
        document.getElementById("professor_lname").style.backgroundColor = 'lightgreen';
}

    self.cantFindProfessor = function() {
         document.getElementById("professor_fname").disabled = false;
         document.getElementById("professor_lname").disabled = false;
        document.getElementById("professor_fname").style.backgroundColor = '#b8d1f3';
        document.getElementById("professor_lname").style.backgroundColor = '#b8d1f3';
}


self.addClass = function() {
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
  
  }]); // end controller


        function addFunction(professorId) {
          var newClass = {};
          var subject = document.getElementById("subject").value;
          var section = document.getElementById("section").value;
          newClass.university_id = 1;
          newClass.professor_id = professorId;
          newClass.name = subject;
          newClass.section = section;
          $.ajax({
            headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
          },
            url: "http://localhost:8080/addclass",
            type: "POST",
            data: JSON.stringify(newClass),
            dataType: 'json'
        })
        }