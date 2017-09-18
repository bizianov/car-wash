

angular.module('weatherApp', [])
    .controller('WeatherCtrl', function ($http) {
        var weatherCtrl = this;

        weatherCtrl.location = {
            city: "",
            country: ""
        };
        weatherCtrl.result = "Empty";

        weatherCtrl.getWeather = function () {
            $http({
                method: "GET",
                url: "http://localhost:8080/weather/" + weatherCtrl.location.city +"/"+ weatherCtrl.location.country
            })
                .then(function (response) {
                    weatherCtrl.result = response.data;
                });
        }
    });
