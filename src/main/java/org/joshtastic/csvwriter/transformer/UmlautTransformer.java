package org.joshtastic.csvwriter.transformer;

/**
 * Transforms german umlauts (e. g. ä -> ae)
 */
public class UmlautTransformer extends CsvTransformer {

    /**
     *
     */
    @Override
    public String transform(Object o) {

        if (o instanceof String) {
            String s = (String) o;
            s = s.replaceAll("Ä", "Ae");
            s = s.replaceAll("Ö", "Oe");
            s = s.replaceAll("Ü", "Ue");
            s = s.replaceAll("ß", "ss");
            s = s.replaceAll("ä", "ae");
            s = s.replaceAll("ö", "oe");
            s = s.replaceAll("ü", "ue");
            return s;
        }
        return null;
    }
}