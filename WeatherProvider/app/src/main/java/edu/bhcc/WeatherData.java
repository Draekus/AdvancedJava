package edu.bhcc;

public class WeatherData {
    String date;
    double precipitation;
    double tempMax;
    double tempMin;
    double windSpeed;
    String weather;

    /**
     * Constructor
     * @param date Date [yyyy-mm-dd]
     * @param precipitation Chance of precipitation
     * @param tempMax Maximum temperature
     * @param tempMin Minimum temperature
     * @param windSpeed Wind speed
     * @param weather One-word description of weather
     */
    public WeatherData(String date, double precipitation, double tempMax, double tempMin, double windSpeed, String weather) {
        this.date = date;
        this.precipitation = precipitation;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.windSpeed = windSpeed;
        this.weather = weather;
    }

}


