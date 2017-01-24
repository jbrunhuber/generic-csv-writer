package org.joshtastic.csvwriter.test.generic;

import org.apache.log4j.Logger;
import org.joshtastic.annotations.GenericCsvWriter;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by josh on 20.01.2017
 */
public class CsvWriterTest {

    private static final Logger LOGGER = Logger.getLogger(CsvWriterTest.class);
    private static final String MOCK_CSV_FILE = "/expected.csv";

    /**
     *
     */
    @Test
    public void testBasicWrite() {

        Bean arabica = new Bean();
        arabica.homeCountry = "Java-Island";
        arabica.price = 13.37f;
        arabica.name = "Arabica";

        Bean robusta = new Bean();
        robusta.homeCountry = "Brasilia";
        robusta.price = 7.37f;
        robusta.name = "Robusta";

        List<Bean> beans = new ArrayList<>();
        beans.add(arabica);
        beans.add(robusta);

        GenericCsvWriter<Bean> writer = new GenericCsvWriter<>();
        byte[] csvFile = writer.writeToByteArray(beans);

        String expected = readExpected();
        Assert.assertEquals(expected, new String(csvFile));
    }

    /**
     * @return the expected csv-file
     */
    private String readExpected() {

        BufferedReader in = new BufferedReader(new InputStreamReader(CsvWriterTest.class.getResourceAsStream(MOCK_CSV_FILE)));

        String expected = "";

        String read;
        try {
            while ((read = in.readLine()) != null) {
                expected += read;
                expected += '\n';
            }
        } catch (IOException e) {
            LOGGER.error(e, e);
        }
        return expected;
    }
}

