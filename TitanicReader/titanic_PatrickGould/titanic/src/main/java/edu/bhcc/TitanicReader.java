package edu.bhcc;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reads in the titanic csv file and extracts the total # of passengers
 * as well as the # of passengers in each class and provides getter
 * methods to access those values
 */
public class TitanicReader {

    private int numPassengers;
    private int numFirstClassPassengers;
    private int numSecondClassPassengers;
    private int numThirdClassPassengers;

    // Instantiate logger
    Logger logger = LoggerFactory.getLogger(TitanicReader.class);

    /**
     * Reads in a csv file and extracts the total number of passengers
     * as well the class of each passenger
     *
     * @param file a file object of the titanic.csv file
     */
    public TitanicReader(File file) {

        try {
            // Create new file reader
            FileReader filereader = new FileReader(file);

            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();

            // Read data from file into a list
            List<String[]> allData = csvReader.readAll();

            // Log reading of file
            logger.info("Parsing file \"" + file.getName() + "\"");

            // Loop over each line of data
            for(String[] row : allData) {

                // Count each passenger
                this.numPassengers++;

                // Count the class of each passenger
                switch (Integer.parseInt(row[2])) {
                    case 1:
                        numFirstClassPassengers++;
                        break;
                    case 2:
                        numSecondClassPassengers++;
                        break;
                    case 3:
                        numThirdClassPassengers++;
                        break;
                    default:
                        break;
                }

            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the total number of passengers
     */
    public int getNumPassengers() {
        logger.info("Returning total number of passengers");
        return numPassengers;
    }

    /**
     * Returns the total number of first class passengers
     */
    public int getNumFirstClassPassengers() {
        logger.info("Returning total number of First Class passengers");
        return numFirstClassPassengers;
    }

    /**
     * Returns the total number of second class passengers
     */
    public int getNumSecondClassPassengers() {
        logger.info("Returning total number of Second Class passengers");
        return numSecondClassPassengers;
    }
    /**
     * Returns the total number of third class passengers
     */
    public int getNumThirdClassPassengers() {
        logger.info("Returning total number of Third Class passengers");
        return numThirdClassPassengers;
    }
}
