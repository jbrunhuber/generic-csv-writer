package org.joshtastic.csvwriter.annotations;

import org.joshtastic.csvwriter.transformer.CsvTransformer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CsvTransform {

    Class<? extends CsvTransformer> value();
}