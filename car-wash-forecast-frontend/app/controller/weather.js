angular.module('weatherApp')
    .controller('WeatherCtrl', ['$scope', 'WeatherProvider', ($scope, WeatherProvider) => {
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

        $scope.getWeather = () => {
            WeatherProvider.getWeatherFunc($scope.selected.value, $scope.location.city, $scope.location.country)
            .then((response) => {
                $scope.result = response.data;
            })
         }
    }]);
