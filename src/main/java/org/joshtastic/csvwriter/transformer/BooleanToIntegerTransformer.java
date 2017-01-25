package org.joshtastic.csvwriter.transformer;

/**
 * Transforms boolean values to integers (e. g.  true -> 1)
 */
public class BooleanToIntegerTransformer implements Transformable {

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