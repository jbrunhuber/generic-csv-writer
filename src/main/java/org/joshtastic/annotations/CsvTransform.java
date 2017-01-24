package org.joshtastic.annotations;

import org.joshtastic.annotations.transformer.CsvTransformer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CsvTransform {

    Class<? extends CsvTransformer> value();
}