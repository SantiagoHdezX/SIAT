﻿var siatApp = angular.module('siatApp', ['ngRoute']);

// configure our routes
siatApp.config(function ($routeProvider) {
    $routeProvider

        // route for the home page
        .when('/', {
            templateUrl: 'pages/home.html',
            controller: 'mainController'
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
});

// create the controller and inject Angular's $scope
siatApp.controller('mainController', function ($scope) {
    // create a message to display in our view
    $scope.message = 'Everyone come and see how good I look!';
    $scope.iniciarSesion = function () {
        window.location.href = "#/user";
    }
});

siatApp.controller('aboutController', function ($scope) {
    $scope.message = 'Aqui debe de ir la informacion correspondiente a la pagina "Acerca de"';
});

siatApp.controller('userHomeController', function ($scope) {
    $scope.Usuario = 'Usuario Ejemplo',
    $scope.personalData = { Nombre: 'Usuario Ejemplo', Domicilio: 'Mariano Escobedo 124 Miguel Hidalgo DF' };
});

siatApp.controller('usergetTaxiController', function ($scope) {
    $scope.solicitud = {
        Nombre: 'Usuario Ejemplo',
        Origen: 'Mariano Escobedo 124 Miguel Hidalgo DF',
        Destino: null
    }
    $scope.getTaxiSuccess = function () {
        alert('Se ha solicitado el taxi, debe de aparecer en su puerta en menos de 15 minutos');
        window.location.href = "#/user";
    }
});