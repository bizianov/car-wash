

angular.module('weatherApp', [])
    .controller('WeatherCtrl', ['$scope', '$http', function ($scope ,$http) {
        $scope.location = {
            city: "",
            country: ""
        };

        $scope.options = [
            { label: "Weather", value: "weather" },
            { label: "Forecast", value: "forecast" }
        ];
        $scope.selected = $scope.options[0];

        $scope.result = "Empty";

        $scope.getWeather = function () {
            $http({
                method: "GET",
                url: "http://localhost:8080/" + $scope.selected.value +
                "/" + $scope.location.city + "/" + $scope.location.country
            })
                .then(function (response) {
                    $scope.result = response.data;
                });
        }
       /* weatherCtrl.getWeather = function () {
            weatherCtrl.result = weatherProvider.getWeatherFunc(weatherCtrl.selected.value, weatherCtrl.location.city, weatherCtrl.location.country)
        }*/
    }]);
