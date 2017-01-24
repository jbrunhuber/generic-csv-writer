package org.joshtastic.csvwriter.test.transformers;

import org.joshtastic.csvwriter.transformer.EscapeTransformer;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by josh on 20.01.2017
 */
public class CsvEscapeTest {

    @Test
    public void test() {

        String value = "I really enjoy coffee; espresso is pretty nice too.";
        String expected = "\"I really enjoy coffee; espresso is pretty nice too.\"";

        EscapeTransformer transformer = new EscapeTransformer();
        String actual = transformer.transform(value);

        Assert.assertEquals(expected, actual);
    }
}