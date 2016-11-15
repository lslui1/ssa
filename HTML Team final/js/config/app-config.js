angular
  .module("myApp")
  .config(routeConfig)

  routeConfig.$inject = ["$routeProvider"]

  function routeConfig($routeProvider) {


		$routeProvider
		.when('/', {
			templateUrl: 'views/login.view.html',
      controller: 'LoginCtrl'
		}).when('/home', {
			templateUrl: 'views/home.view.html'
		}).when('/classes', {
			templateUrl: 'views/classes.view.html',
      controller: 'ClassCtrl'
		}).when('/addclass', {
			templateUrl: 'views/addclass.view.html',
      controller: 'ClassCtrl'
		}).when('/submittedclass', {
			templateUrl: 'views/submittedclass.view.html',
		}).when('/submittedprofessor', {
			templateUrl: 'views/submittedprofessor.view.html',
		}).when('/submittedreview', {
			templateUrl: 'views/submittedreview.view.html',
		}).when('/addprofessor', {
			templateUrl: 'views/addprofessor.view.html',
      controller: 'ProfessorCtrl'
		}).when('/professors', {
			templateUrl: 'views/professors.view.html',
      controller: 'ProfessorCtrl'
		}).when('/professorclasses/:pathingprofId', {
			templateUrl: 'views/professorclasses.view.html',
      controller: 'ClassCtrl'
		}).when('/professorreview/:pathingprofId', {
			templateUrl: 'views/professorreview.view.html',
      controller: 'ClassCtrl'
		}).when('/addreview', {
			templateUrl: 'views/addreview.view.html',
      controller: 'ReviewCtrl'
		}).when('/review/:reviewClassId', {
			templateUrl: 'views/review.view.html',
      controller: 'ReviewCtrl'
		}).when('/myreviews', {
			templateUrl: 'views/myreviews.view.html',
      controller: 'ReviewCtrl'
		}).when('/editingmyreview', {
			templateUrl: 'views/editingmyreview.view.html',
      controller: 'ReviewCtrl'
		}).when('/editsuccessful', {
			templateUrl: 'views/submittededitreview.view.html',
      controller: 'ReviewCtrl'
		}).when('/myclasses', {
			templateUrl: 'views/myclasses.view.html',
      controller: 'ClassCtrl'
		}).when('/alternativeclasses', {
			templateUrl: 'views/alternativeclasses.view.html',
      controller: 'ClassCtrl'
		})
		.otherwise({redirectTo: '/'});

	} // end config

;
