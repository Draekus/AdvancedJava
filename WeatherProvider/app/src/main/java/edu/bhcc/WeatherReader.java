package edu.bhcc;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WeatherReader {
    final String FILE_LOCATION = "C:/Users/salad/Documents/School/CSC-AdvancedJava/WeatherProvider/app/src/main/data/seattle-weather.csv";
    HashMap<String, WeatherData> weatherHashMap;

    public WeatherReader() {
        this.weatherHashMap = readData();
    }

    /**
     * Reads the weather data csv into memory and returns a hashmap connecting dates to weather data
     * @return
     */
    private HashMap<String, WeatherData> readData() {
        try {
            File weatherDataCSV = new File(FILE_LOCATION);
            // Create new file reader
            FileReader filereader = new FileReader(weatherDataCSV);

            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();

            // Read data from file into a list
            List<String[]> allData = csvReader.readAll();

            // Log reading of file
            //logger.info("Parsing file \"" + file.getName() + "\"");
            HashMap<String, WeatherData> tempWeatherHashMap = new HashMap<String, WeatherData>();

            // Loop over each line of data
            for(String[] row : allData) {
                // Extract date, precipitation, temperature, wind speed, and weather from list
                String date = row[0];
                double precip = Double.parseDouble(row[1]);
                double tempMax = Double.parseDouble(row[2]);
                double tempMin = Double.parseDouble(row[3]);
                double wind = Double.parseDouble(row[4]);
                String weather = row[5];
                System.out.println("weather = " + weather);
                System.out.println("date = " + date);
                // Create new weatherData object with extracted data
                WeatherData rowWeatherData = new WeatherData(date, precip, tempMax, tempMin, wind, weather);
                System.out.println("rowWeatherData.toString() = " + rowWeatherData);
                // Insert weatherData object into the weather HashMap
                tempWeatherHashMap.put(date, rowWeatherData);
            }
            return tempWeatherHashMap;
        }
        catch(Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

}

