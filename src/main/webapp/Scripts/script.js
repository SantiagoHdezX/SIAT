var siatApp = angular.module('siatApp', ['ngRoute']);

// configure our routes
siatApp.config(function ($routeProvider) {
    $routeProvider

            // route for the home page
            .when('/', {
                templateUrl: 'Views/Home.html',
                controller: 'mainController'
            })
            .when('/Register', {
                templateUrl: 'Views/Register.html',
                controller: 'RegisterCtrl'
            })
            // route for the about page
            .when('/about', {
                templateUrl: 'pages/about.html',
                controller: 'aboutController'
            })
            .when('/user', {
                templateUrl: 'pages/user/home.html',
                controller: 'userHomeController'
            })
            .when('/user/getTaxi', {
                templateUrl: 'pages/user/getTaxi.html',
                controller: 'usergetTaxiController'
            })
            .when('/admin', {
                templateUrl: 'pages/admin/home.html',
                controller: 'adminController'
            });
});

// create the controller and inject Angular's $scope
siatApp.controller('mainController', function ($scope) {
    // create a message to display in our view
    $scope.message = 'Everyone come and see how good I look!';
    $scope.iniciarSesion = function (login) {
        if (login === undefined) {
            alert('Ingrese sus credenciales para iniciar sesion');
            window.location.href = "#/";
        }
        else {
            switch (parseInt(login.type.toString())) {
                case 1:
                    window.location.href = "#/User";
                    break;
                case 2:
                    window.location.href = "#/TaxiDriver";
                    break;
                case 3:
                    window.location.href = "#/Central";
                    break;
                case 4:
                    window.location.href = "#/Directive";
                    break;
            }
        }
    };
});

siatApp.controller('RegisterCtrl', function ($scope, $http) {
    $scope.Register = {Address: {Estado: 'Distrito Federal'}};
    $scope.RegistrarUsuario = function (Register) {
        $http.post('/WebAPI/Users/Create', Register)
                .success(function(data){
                    alert(data.Status);
                }).error(function(data){
                    alert(data);
                });
    };
    $scope.Salir= function(){
        window.location.href="#/";
    };
});

siatApp.controller('adminController', function ($scope) {
    $scope.Usuario = 'Administrador Ejemplo';
    $scope.personalData = {Nombre: 'Administrador Ejemplo', Domicilio: 'Domicilio Ejemplo'};
});

siatApp.controller('aboutController', function ($scope) {
    $scope.message = 'Aqui debe de ir la informacion correspondiente a la pagina "Acerca de"';
});

siatApp.controller('userHomeController', function ($scope) {
    $scope.Usuario = 'Usuario Ejemplo',
            $scope.personalData = {Nombre: 'Usuario Ejemplo', Domicilio: 'Mariano Escobedo 124 Miguel Hidalgo DF'};
});

siatApp.controller('usergetTaxiController', function ($scope) {
    $scope.solicitud = {
        Nombre: 'Usuario Ejemplo',
        Origen: 'Mariano Escobedo 124 Miguel Hidalgo DF',
        Destino: null
    },
    $scope.getTaxiSuccess = function () {
        alert('Se ha solicitado el taxi, debe de aparecer en su puerta en menos de 15 minutos');
        window.location.href = '#/user';
    },
            $scope.cancelTaxi = function () {
                alert('Se ha cancelado la operacion');
                window.location.href = '#/user';
            };
});