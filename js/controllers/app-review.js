angular
  .module("myApp")
  .controller("ReviewCtrl", ReviewCtrl)

  ReviewCtrl.$inject = ['$http', '$window','$scope','$routeParams']
  function ReviewCtrl($http, $window, $scope, $routeParams) {
  var self = this
  self.currentClassId = $routeParams.reviewClassId;
  self.loginId = sessionStorage.globaluserid


  self.showClassName = sessionStorage.reviewClassName
  self.showClassSection = sessionStorage.reviewClassSection
  self.showClassFname = sessionStorage.reviewClassFname
  self.showClassLname = sessionStorage.reviewClassLname

  $http.get('http://localhost:8080/ReviewsByClass/' + self.currentClassId)
      			.then(function(resp){
        			self.reviews = resp.data;
        		},function(err) {

        		});


            $http.get('http://localhost:8080/combinedreviewsbyloginid/' + self.loginId)
                			.then(function(resp){
                  			self.mysavedreviews = resp.data;
                  		},function(err) {

                  		});








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
                  $window.location.href = '/#/submittedreview';
                }, function(err) {
                  console.log("FAILURE: " + resp)
                });
            }




}
