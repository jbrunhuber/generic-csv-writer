package org.joshtastic.annotations.transformer;

/**
 * Escapes a csv string literal
 */
public class EscapeTransformer extends CsvTransformer {

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