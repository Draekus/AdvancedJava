package edu.bhcc;

/*
 * Titanic
 *
 * Description: This program uses OpenCSV to read the total number of passengers in each class
 *              from the titanic passenger manifest (CSV). It then prints those values to the screen.
 *              It utilizes JUnit for unit testing & slf4j for logging.
 *
 * Created by Patrick Gould
 * CSC-285-01
 * 2/13/2023
 *
 */


import java.io.File;

public class Titanic
{
    public static void main( String[] args )
    {
        // Create a new file with the path to the titanic dataset
        File titanic_manifest = new File("src/test/test_data/titanic.csv");
        // Instantiate a new TitanicReader object to read the dataset
        TitanicReader reader = new TitanicReader(titanic_manifest);

        // Print all the passenger totals out to the screen
        System.out.println("Total: " + reader.getNumPassengers());
        System.out.println("1st Class: " + reader.getNumFirstClassPassengers());
        System.out.println("2nd Class: " + reader.getNumSecondClassPassengers());
        System.out.println("3rd Class: " + reader.getNumThirdClassPassengers());

    }
}
