package org.joshtastic.csvwriter.transformer;

/**
 * Escapes a csv string literal
 */
public class EscapeTransformer implements Transformable {

    /**
     *
     */
    @Override
    public String transform(Object o) {

        if (o instanceof String) {
            return "\"" + o + "\"";
        }
        return null;
    }
}