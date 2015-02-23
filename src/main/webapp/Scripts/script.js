var siatApp = angular.module('siatApp', ['ngRoute']);

var UserCentral = {
    CorreoElectronico: 'central@siat.com',
    Passwd: '123456*'
};

var UserDirective = {
    CorreoElectronico: 'directivo@siat.com',
    Passwd: '123456*'
};

// configure our routes
siatApp.config(function ($routeProvider) {
    $routeProvider
            .when('/', {
                templateUrl: 'Views/Home.html',
                controller: 'mainController'
            })
            .when('/Register', {
                templateUrl: 'Views/Register.html',
                controller: 'RegisterCtrl'
            })
            .when('/User', {
                templateUrl: 'Views/User/HomeUser.html',
                controller: 'UserCtrl'
            })
            .when('/User/Datos', {
                templateUrl: 'Views/User/Datos.html',
                controller: 'UserCtrl'
            })
            .when('/User/SolicitarTaxi', {
                templateUrl: 'Views/User/SolicitarTaxi.html',
                controller: 'UserCtrl'
            })
            // route for the about page
            .when('/about', {
                templateUrl: 'pages/about.html',
                controller: 'aboutController'
            });
});

// create the controller and inject Angular's $scope
siatApp.controller('mainController', function ($scope) {
    switch (parseInt(localStorage.Role)) {
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
        default:
//            window.location.href = "#/";
            break;
    }
    // create a message to display in our view
    $scope.login = {type: 1};
    $scope.iniciarSesion = function (login) {
        if (login === undefined) {
//            alert('Ingrese sus credenciales para iniciar sesion');
//            window.location.href = "#/";
        }
        else {
            switch (parseInt(login.type.toString())) {
                case 1:
                    if (localStorage.NormalUser === undefined) {
                        alert('No hay usuario registrado');
                    }
                    else {
                        var actualUser = JSON.parse(localStorage.NormalUser);
                        if (login.email === actualUser.CorreoElectronico && login.passwd === actualUser.Passwd) {
                            localStorage.Role = 1;
                            window.location.href = "#/User";
                        }
                        else {
                            alert('Sus credenciales son incorrectas');
                        }
                    }
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
                default:
                    alert('Revise sus datos');
                    break;
            }
        }
    };
});
siatApp.controller('UserCtrl', function ($scope) {
    switch (parseInt(localStorage.Role)) {
        case 1:
//            window.location.href = "#/User";
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
        default:
            window.location.href = "#/";
            break;
    }

    $scope.Register = JSON.parse(localStorage.NormalUser);

    $scope.ActualizarUsuario = function (Register) {
        localStorage.NormalUser = angular.toJson(Register);
        alert('Se ha actualizado el usuario');
        window.location.href = "#/User";
    };
    
    $scope.CerrarSesion = function(){
        localStorage.removeItem("Role");
        window.location.href="#/";
    }
});

siatApp.controller('RegisterCtrl', function ($scope) {
    $scope.Register = {Address: {Estado: 'Distrito Federal'}};
    $scope.RegistrarUsuario = function (Register) {
        localStorage.NormalUser = angular.toJson(Register);
        alert('Se ha registrado su usuario exitosamente');
        window.location.href = '#/';
    };
    $scope.Salir = function () {
        window.location.href = "#/";
    };
});

siatApp.controller('adminController', function ($scope) {
    $scope.Usuario = 'Administrador Ejemplo';
    $scope.personalData = {Nombre: 'Administrador Ejemplo', Domicilio: 'Domicilio Ejemplo'};
});

siatApp.controller('aboutController', function ($scope) {
    $scope.message = 'Aqui debe de ir la informacion correspondiente a la pagina "Acerca de"';
});

siatApp.controller('usergetTaxiController', function ($scope) {
    $scope.solicitud = {
        Nombre: 'Usuario Ejemplo',
        Origen: 'Mariano Escobedo 124 Miguel Hidalgo DF',
        Destino: null
    };
    $scope.getTaxiSuccess = function () {
        alert('Se ha solicitado el taxi, debe de aparecer en su puerta en menos de 15 minutos');
        window.location.href = '#/user';
    };
    $scope.cancelTaxi = function () {
        alert('Se ha cancelado la operacion');
        window.location.href = '#/user';
    };
});