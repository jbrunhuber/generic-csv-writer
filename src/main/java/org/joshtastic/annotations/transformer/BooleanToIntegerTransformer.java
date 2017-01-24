package org.joshtastic.annotations.transformer;

/**
 * Transforms boolean values to integers (e. g.  true -> 1)
 */
public class BooleanToIntegerTransformer extends CsvTransformer {

    /**
     *
     */
    @Override
    public String transform(Object o) {

        if ((o == null) || !(o instanceof Boolean)) {
            return null;
        }

        return ((Boolean) o) ? "1" : "0";
    }
}