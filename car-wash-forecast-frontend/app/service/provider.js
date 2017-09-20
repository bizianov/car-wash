angular.module('weatherApp', [])
    .service('WeatherProvider', ['$http', ($http) => {
        this.getWeatherFunc = (weatherMode, city, country) => {
            return $http({
                method: 'GET',
                url: "http://localhost:8080/" + weatherMode + "/" + city + "/" + country
            })
        }
    }]);

