var siatApp = angular.module('siatApp', ['ngRoute']);

var UserCentral = {
    CorreoElectronico: 'central@siat.com',
    Passwd: '123456*'
};

var UserDirective = {
    CorreoElectronico: 'directivo@siat.com',
    Passwd: '123456*'
};

var UserAdmin = {
    CorreoElectronico: 'administrador@siat.com',
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
            .when('/Admin', {
                templateUrl: 'Views/Admin/HomeAdmin.html',
                controller: 'AdminCtrl'
            })
            .when('/Admin/Bitacora', {
                templateUrl: 'Views/Admin/Bitacora.html',
                controller: 'AdminCtrl'
            })
            .when('/Admin/PadronVehicular', {
                templateUrl: 'Views/Admin/PadronVehicular.html',
                controller: 'AdminCtrl'
            })
            .when('/Admin/RegistrarTaxi', {
                templateUrl: 'Views/Admin/RegistrarTaxi.html',
                controller: 'AdminCtrl'
            })
            .when('/Central', {
                templateUrl: 'Views/Central/HomeCentral.html',
                controller: 'CentralCtrl'
            })
            .when('/Central/Bitacora', {
                templateUrl: 'Views/Central/BitacoraOperativa.html',
                controller: 'CentralCtrl'
            })
            .when('/Central/PadronVehicular', {
                templateUrl: 'Views/Central/PadronVehicular.html',
                controller: 'CentralCtrl'
            })
            .when('/Central/Servicios', {
                templateUrl: 'Views/Central/Servicios.html',
                controller: 'CentralCtrl'
            })
            .when('/Central/Clientes', {
                templateUrl: 'Views/Central/Clientes.html',
                controller: 'CentralCtrl'
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
            window.location.href = "#/Admin";
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
                    if (login.email === UserAdmin.CorreoElectronico && login.passwd === UserAdmin.Passwd) {
                        localStorage.Role = 2;
                        window.location.href = "#/Admin";
                    }
                    else {
                        alert('Sus credenciales son incorrectas');
                    }
                    break;
                case 3:
                    if (login.email === UserCentral.CorreoElectronico && login.passwd === UserCentral.Passwd) {
                        localStorage.Role = 3;
                        window.location.href = "#/Central";
                    }
                    else {
                        alert('Sus credenciales son incorrectas');
                    }
                    window.location.href = "#/Central";
                    break;
                case 4:
                    if (login.email === UserDirective.CorreoElectronico && login.passwd === UserDirective.Passwd) {
                        localStorage.Role = 4;
                        window.location.href = "#/Directive";
                    } else {
                        alert('Sus credenciales son incorrectas');
                    }
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
            window.location.href = "#/Admin";
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
    $scope.Solicitud = {Origen: {Estado: 'Distrito Federal'}, Destino: {Estado: 'Distrito Federal'}}

    $scope.ActualizarUsuario = function (Register) {
        localStorage.NormalUser = angular.toJson(Register);
        alert('Se ha actualizado el usuario');
        window.location.href = "#/User";
    };

    $scope.SolicitarTaxi = function (Solicitud) {
        if (!(Solicitud === undefined)) {
            Solicitud["Usuario"] = JSON.parse(localStorage.NormalUser);
            localStorage.Solicitud = angular.toJson(Solicitud);
            alert('Se ha solicitado el taxi');
            window.location.href = "#/User";
        }
        else {
            alert('Llene correctamente los campos del formulario');
        }
    };

    $scope.CerrarSesion = function () {
        localStorage.removeItem("Role");
        window.location.href = "#/";
    };
});

siatApp.controller('AdminCtrl', function ($scope) {
    switch (parseInt(localStorage.Role)) {
        case 1:
            window.location.href = "#/User";
            break;
        case 2:
//            window.location.href = "#/Admin";
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
    $scope.CerrarSesion = function () {
        localStorage.removeItem("Role");
        window.location.href = "#/";
    };
});

siatApp.controller('CentralCtrl', function ($scope) {
    switch (parseInt(localStorage.Role)) {
        case 1:
            window.location.href = "#/User";
            break;
        case 2:
            window.location.href = "#/Admin";
            break;
        case 3:
//            window.location.href = "#/Central";
            break;
        case 4:
            window.location.href = "#/Directive";
            break;
        default:
            window.location.href = "#/";
            break;
    }
    $scope.CerrarSesion = function () {
        localStorage.removeItem("Role");
        window.location.href = "#/";
    };
});

siatApp.controller('DirectiveCtrl', function ($scope) {
    switch (parseInt(localStorage.Role)) {
        case 1:
            window.location.href = "#/User";
            break;
        case 2:
            window.location.href = "#/Admin";
            break;
        case 3:
            window.location.href = "#/Central";
            break;
        case 4:
//            window.location.href = "#/Directive";
            break;
        default:
            window.location.href = "#/";
            break;
    }
    $scope.CerrarSesion = function () {
        localStorage.removeItem("Role");
        window.location.href = "#/";
    };
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