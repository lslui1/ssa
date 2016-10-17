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
		}).when('/submitted', {
			templateUrl: 'views/submittedclass.view.html',
		}).when('/submittedprofessor', {
			templateUrl: 'views/submittedprofessor.view.html',
		}).when('/professors', {
			templateUrl: 'views/professors.view.html',
      controller: 'ProfessorCtrl'
		}).when('/addprofessor', {
			templateUrl: 'views/addprofessor.view.html',
      controller: 'ProfessorCtrl'
		}).when('/review/:reviewClassId', {
			templateUrl: 'views/review.view.html',
      controller: 'ReviewCtrl'
		}).when('/myreviews', {
			templateUrl: 'views/myreviews.view.html'
		}).when('/myclasses', {
			templateUrl: 'views/myclasses.view.html'
		})
		.otherwise({redirectTo: '/'});

	} // end config

;
