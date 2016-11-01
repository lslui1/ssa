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
                  sessionStorage.setItem("returnstate", "addprofessor")
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


self.buildArrays = function(professorId) {
   var classRatingArray = new Array();
   var profRatingArray = [];
   var ArrayArray = [];
   var profRatingTotal = 0;
   var classRatingTotal = 0;
   var profRatingAvg = [];
   var classRatingAvg = [];
   var count = 0;
   $.ajax({
            url: 'http://localhost:8080/ReviewsByProfessor/' + professorId,
            type: "GET"})
        .then(function(resp){
          resp.sort(compare)
        for (i = 0; i<resp.length; i++) {
          profRatingTotal += resp[i].professor_rating;
          classRatingTotal += resp[i].class_rating;
          count += 1;
          prAvg = profRatingTotal/count;
          crAvg = classRatingTotal/count;
          var dateIn = resp[i].review_date;
          var year = dateIn.substring(0,4);
          var month = dateIn.substring(5,7) - 1;
          var day = dateIn.substring(8,10);
          console.log(year + "is year" + month + "is month" + day + "is day");
          profRatingAvg.push({x: new Date(year, month, day), y: prAvg, lineColor: "DeepSkyBlue", markerColor: "DeepSkyBlue", markerSize: 1});
          classRatingAvg.push({x: new Date(year, month, day), y: crAvg, lineColor: "Tomato", markerColor: "Tomato", markerSize: 1});
          profRatingArray.push({x: new Date(year, month, day), y: resp[i].professor_rating, lineColor: "DeepSkyBlue", markerColor: "DeepSkyBlue"});
          classRatingArray.push({x: new Date(year, month, day), y: resp[i].class_rating, lineColor: "Tomato", markerColor: "Tomato"});
        }
        buildChart(classRatingArray, profRatingArray, classRatingAvg, profRatingAvg)
    })

}

//Functions for pop-up modal

self.buildModal = function() {
  console.log("a")
var modal = document.getElementById('myModal');
var btn = document.getElementById("myBtn");
var span = document.getElementsByClassName("close")[0];
  console.log("g")
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
self.spanClick = function() {
  var modal = document.getElementById('myModal');
    modal.style.display = "none";
}



}

function buildChart(classRatingArray, profRatingArray, classRatingAvg, profRatingAvg) {
console.log("inbuildchart")
console.log(classRatingArray)
   var chart = new CanvasJS.Chart("chartContainer",
  {
    backgroundColor: "transparent",
    animationEnabled: true,
    title:{
      text: "Professor's Ratings Over Time",
      fontColor: "white"
    },
    axisY: {
      maximum: 6,
      interval: 1,
      gridColor: "F3F2F2",
      labelFontColor: "white"
    },
    axisX: {
      valueFormatString: "MM-DD-YYYY",
      gridColor: "F3F2F2",
      labelFontColor: "white"
    },

    data: [

      {
      type: "spline",
      legendText: "Professor Ratings",
      legendMarkerColor: "DeepSkyBlue",
      markerColor: "DeepSkyBlue",
      showInLegend: true,
      dataPoints: profRatingArray
      },
      {
      type: "spline", //change type to bar, line, area, pie, etc
      legendText: "Class Ratings",
      legendMarkerColor: "Tomato",
      markerColor: "Tomato",
      showInLegend: true,
      dataPoints: classRatingArray
      },
         {
      type: "spline",
      lineDashType: "dash",
      legendText: "Professor Rating Average",
      legendMarkerColor: "DeepSkyBlue",
      markerColor: "DeepSkyBlue",
      markerSize: 0,
      color: "DeepSkyBlue",
      legendMarkerType: "triangle",
      showInLegend: true,
      dataPoints: profRatingAvg
      },
      {
      type: "spline",
      lineDashType: "dash",
      legendText: "Class Rating Average",
      markerColor: "Tomato",
      markerSize: 0,
      color: "Tomato",
      legendMarkerColor: "Tomato",
      legendMarkerType: "none",
      showInLegend: true,
      dataPoints: classRatingAvg
      }

    ],
    legend: {
      fontSize: 15,
      fontColor: "white",
      cursor: "pointer",
      itemclick: function (e) {
        if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
          e.dataSeries.visible = false;
        } else {
          e.dataSeries.visible = true;
      }
      chart.render();
      }
    }
  })


  chart.render();

        };


                function compare(a,b) {
  if (a.review_date < b.review_date)
    return -1;
  if (a.review_date > b.review_date)
    return 1;
  return 0;
}
