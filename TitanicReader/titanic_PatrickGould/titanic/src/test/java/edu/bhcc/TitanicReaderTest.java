package edu.bhcc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;

/**
 *  Unit tests for TitanicReader.
 */
public class TitanicReaderTest {
    // Instantiate logger
    Logger logger = LoggerFactory.getLogger(TitanicReaderTest.class);

    // Create new file with path to the titanic dataset
    File titanic_manifest = new File("src/test/test_data/titanic.csv");
    // Create TitanicReader object for testing
    TitanicReader testReader = new TitanicReader(titanic_manifest);

    /**
     * Tests if the total number of passengers is correct
     */
    @Test
    public void getNumPassengersTest() {
        logger.info("Testing if passenger total is correct");
        assertEquals(891, testReader.getNumPassengers());
    }
    /**
     * Tests if the total number of second class passengers is correct
     */
    @Test
    public void getNumFirstClassPassengersTest() {
        logger.info("Testing if First Class passenger total is correct");
        assertEquals(216, testReader.getNumFirstClassPassengers());
    }
    /**
     * Tests if the total number of second class passengers is correct
     */
    @Test
    public void getNumSecondClassPassengersTest() {
        logger.info("Testing if Second Class passenger total is correct");
        assertEquals(184, testReader.getNumSecondClassPassengers());
    }
    /**
     * Tests if the total number of third class passengers is correct
     */
    @Test
    public void getNumThirdClassPassengersTest() {
        logger.info("Testing if Third Class passenger total is correct");
        assertEquals(491, testReader.getNumThirdClassPassengers());
    }
}
