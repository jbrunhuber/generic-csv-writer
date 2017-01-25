package org.joshtastic.csvwriter.annotations;

import org.joshtastic.csvwriter.transformer.Transformable;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CsvTransform {

    Class<? extends Transformable> value();
}