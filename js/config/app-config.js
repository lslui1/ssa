angular
  .module("myApp")
  .config(routeConfig)

  routeConfig.$inject = ["$routeProvider"]

  function routeConfig($routeProvider) {

		$routeProvider
		.when('/', {
			templateUrl: 'views/login.view.html'
		}).when('/home', {
			templateUrl: 'views/home.view.html'
		}).when('/classes', {
			templateUrl: 'views/classes.view.html'
		}).when('/professors', {
			templateUrl: 'views/professors.view.html'
		}).when('/myreviews', {
			templateUrl: 'views/myreviews.view.html'
		}).when('/myclasses', {
			templateUrl: 'views/myclasses.view.html'
		})
		.otherwise({redirectTo: '/'});

	} // end config

;
