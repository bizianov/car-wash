angular.module('weatherApp')
    .controller('WeatherCtrl', ['$scope', 'WeatherProvider', function($scope, WeatherProvider) {
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
            WeatherProvider.getWeatherFunc($scope.selected.value, $scope.location.city, $scope.location.country)
            .then(function (response) {
                $scope.result = response.data;
            })
         }
    }]);
