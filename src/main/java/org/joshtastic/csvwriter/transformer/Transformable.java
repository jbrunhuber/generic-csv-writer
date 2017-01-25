package org.joshtastic.csvwriter.transformer;

/**
 *
 */
@FunctionalInterface
public interface Transformable {

    String transform(Object o);
}