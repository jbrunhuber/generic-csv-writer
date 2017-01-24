package org.joshtastic.csvwriter.test.transformers;

import org.joshtastic.csvwriter.transformer.UmlautTransformer;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by josh on 20.01.2017
 */
public class UmlautTransformTest {

    @Test
    public void testDefaultTransformation() {

        String value = "The german guy Klaus Öberüßter drinks the most beer of us";

        String expected = "The german guy Klaus Oeberuesster drinks the most beer of us";
        String actual = new UmlautTransformer().transform(value);

        Assert.assertEquals(expected, actual);
    }
}