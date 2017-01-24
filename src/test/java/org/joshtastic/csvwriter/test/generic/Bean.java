package org.joshtastic.csvwriter.test.generic;

import org.joshtastic.csvwriter.annotations.CsvEntry;

/**
 *
 */
class Bean {

    @CsvEntry(0)
    String name;

    @CsvEntry(1)
    String homeCountry;

    @CsvEntry(2)
    float price;
}