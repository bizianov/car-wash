

angular.module('weatherApp', [])
    .controller('WeatherCtrl', function ($http) {
        var weatherCtrl = this;

        weatherCtrl.location = {
            city: "",
            country: ""
        };

        weatherCtrl.options = ["weather", "forecast"];

        weatherCtrl.selected = weatherCtrl.options[0];

        weatherCtrl.result = "Empty";

        weatherCtrl.getWeather = function () {
            $http({
                method: "GET",
                url: "http://localhost:8080/" + weatherCtrl.selected + "/" + weatherCtrl.location.city +"/"+ weatherCtrl.location.country
            })
                .then(function (response) {
                    weatherCtrl.result = response.data;
                });
        }
    });
