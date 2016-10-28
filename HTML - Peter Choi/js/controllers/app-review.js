angular
  .module("myApp")
  .controller("ReviewCtrl", ReviewCtrl)

  ReviewCtrl.$inject = ['$http', '$window','$scope','$routeParams']
  function ReviewCtrl($http, $window, $scope, $routeParams) {
  var self = this
  self.currentClassId = $routeParams.reviewClassId;
  self.loginId = sessionStorage.globaluserid
  self.myReviewId = sessionStorage.myreviewid


  self.showClassName = sessionStorage.reviewClassName
  self.showClassSection = sessionStorage.reviewClassSection
  self.showClassFname = sessionStorage.reviewClassFname
  self.showClassLname = sessionStorage.reviewClassLname

  self.editReviewClassName = sessionStorage.editReviewClassName
  self.editReviewSectionName = sessionStorage.editReviewSectionName
  self.editReviewFName = sessionStorage.editReviewFName
  self.editReviewLName = sessionStorage.editReviewLName



  // self.showClassName = sessionStorage.showClassName
  // self.showClassSection = sessionStorage.showClassSection
  // self.showClassFname = sessionStorage.showClassFname
  // self.showClassLname = sessionStorage.showClassLname

  self.onestar = '\u2605';
  self.twostar = '\u2605' + '\u2605';
  self.threestar = '\u2605' + '\u2605' + '\u2605';
  self.fourstar = '\u2605' + '\u2605' + '\u2605' + '\u2605';
  self.fivestar = '\u2605' + '\u2605' + '\u2605' + '\u2605' + '\u2605';

if(self.currentClassId != undefined) {
  $http.get('http://localhost:8080/ReviewsByClass/' + self.currentClassId)
      			.then(function(resp){
        			self.reviews = resp.data;
        		},function(err) {

        		})};


if(self.loginId != undefined) {
            $http.get('http://localhost:8080/combinedreviewsbyloginid/' + self.loginId)
                			.then(function(resp){
                  			self.mysavedreviews = resp.data;
                        console.log(self.mysavedreviews)
                  		},function(err) {

                  		})};



if(self.myReviewId != undefined) {
                      $http.get('http://localhost:8080/SingleReview/' + self.myReviewId)
                          			.then(function(resp){
                            			self.singlereview = resp.data;
                                  console.log(self.singlereview)
                            		},function(err) {

                            		})};

self.saveReviewId = function(reviewid,reviewclassname,reviewsectionname,reviewfname,reviewlname) {
  sessionStorage.setItem("myreviewid", reviewid)
  sessionStorage.setItem("editReviewClassName", reviewclassname)
  sessionStorage.setItem("editReviewSectionName", reviewsectionname)
  sessionStorage.setItem("editReviewFName", reviewfname)
  sessionStorage.setItem("editReviewLName", reviewlname)
}

self.saveProfName = function(firstName, secondName) {
  sessionStorage.setItem("PROFESSORfname", firstName)
  sessionStorage.setItem("PROFESSORlname", secondName)
}


self.editMyReview = function(loginid, id, classid, classReview, profReview, year, semester, classRating, professorRating) {
  var myReview = {};
  myReview.login_id = loginid;
  myReview.id = id;
  myReview.class_id = classid;
  myReview.class_review = classReview;
  myReview.professor_review = profReview;
  myReview.year = year;
  myReview.semester = semester;
  myReview.class_rating = classRating;
  myReview.professor_rating = professorRating;
  myReview.review_date = null;

  console.log("sdjkfjksdfj")
  console.log(self.professor_rating)
  console.log(myReview)

  $http({
    method: 'PUT',
    url: 'http://localhost:8080/updatereview',
    data: myReview
  })
    .then(function(resp) {
      console.log("SUCCESS: " + resp)
      sessionStorage.setItem("returnstate", "editmyreview");
      $window.location.href = '/#/editsuccessful';
    }, function(err) {
      console.log("FAILURE: " + err)
    });
}





  self.addReview = function(profReview, classReview, year, semester, classRating, profRating) {
              var myReview = {};
              myReview.professor_review = profReview;
              myReview.class_review = classReview;
              myReview.login_id = sessionStorage.globaluserid;
              myReview.class_id = sessionStorage.reviewClassId;
              myReview.review_date = null;
              myReview.year = year;
              myReview.semester = semester;
              myReview.class_rating = classRating;
              myReview.professor_rating = profRating;

              // var myReview = {"professor_review": "sdfsdfsdfsfsdfsdf",
              //                 "class_review": "sdfsdfsf",
              //                 "login_id": 4,
              //                 "class_id": 18,
              //                 "review_date": null,
              //                 "year": 2016,
              //                 "semester": 1,
              //                 "class_rating": 1,
              //                 "professor_rating": 1};



              sessionStorage.setItem("Reviewprofreview", profReview);
              sessionStorage.setItem("Reviewclassreview", classReview);
              sessionStorage.setItem("Reviewreviewdate", myReview.review_date);
              sessionStorage.setItem("Reviewyear", year);
              sessionStorage.setItem("Reviewsemester", semester);
              sessionStorage.setItem("Reviewclassrating", classRating);
              sessionStorage.setItem("Reviewprofrating", profRating);

              console.log(myReview)

              $http({
                method: 'POST',
                url: 'http://localhost:8080/insertreview',
                data: myReview
              })
                .then(function(resp) {
                  console.log("SUCCESS: " + resp)
                  sessionStorage.setItem("returnstate", "addreview");
                  $window.location.href = '/#/submittedreview';
                }, function(err) {
                  console.log("FAILURE: " + resp)
                });
            }


            //Sort Methods //
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

var sortCR = false;
self.sortCR = function() {
  if (sortCR == false) {
    sortType = '-class_rating';
    sortCR = true;
  }
  else {
    sortType = 'class_rating';
    sortCR = false;
  }
  return sortType
}

var sortPR = false;
self.sortPR = function() {
  if (sortPR == false) {
    sortType = '-professor_rating';
    sortPR = true;
  }
  else {
    sortType = 'professor_rating';
    sortPR = false;
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






}
