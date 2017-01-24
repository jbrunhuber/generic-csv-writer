package org.joshtastic.csvwriter.test.transformers;

import org.joshtastic.csvwriter.transformer.BooleanToIntegerTransformer;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by p08758 on 20.01.2017
 */
public class BooleanToIntegerTest {

    @Test
    public void testDefaultTransformation() {

        boolean value = true;
        String expected = "1";

        String actual = new BooleanToIntegerTransformer().transform(value);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTypeMismatchTransformation() {

        float value = 13.37f;
        String expected = null;

        String actual = new BooleanToIntegerTransformer().transform(value);

        Assert.assertEquals(expected, actual);
    }
}
