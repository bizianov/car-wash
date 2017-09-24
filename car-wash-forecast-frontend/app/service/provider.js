angular.module('weatherApp', [])
    .service('WeatherProvider', ['$http', function($http) {
        this.getWeatherFunc = function(weatherMode, city, country) {
            return $http({
                method: 'GET',
                url: "http://localhost:8080/" + weatherMode + "/" + city + "/" + country
            })
        }
    }]);

