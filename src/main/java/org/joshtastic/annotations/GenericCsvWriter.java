package org.joshtastic.annotations;

import org.apache.log4j.Logger;
import org.joshtastic.annotations.transformer.CsvTransformer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

/**
 * The most innovative csv-writer ever
 *
 * @param <T>
 */
public class GenericCsvWriter<T> {

    private static final Logger LOGGER = Logger.getLogger(GenericCsvWriter.class);

    private static final String CSV_COLUMN_SEPARATOR = ";";

    private static final String CSV_LINE_SEPARATOR = "\n";
    private static final int DEFAULT_START_INDEX = 0;
    private static final String ENCODING = "UTF-8";


    /**
     * Writes a list comma-separated in a byte-array
     *
     * @param dataList the list of the actual data
     * @return csv-file as a byte-array
     */
    public byte[] writeToByteArray(List<T> dataList) {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            this.writeToStream(dataList, bos);
        } catch (IOException e) {
            LOGGER.error(e, e);
        }
        return bos.toByteArray();
    }


    /**
     * Writes a whole list comma-separated in a steam
     *
     * @param dataList the list of data to write in the csv-file
     * @param stream   the target output-stream for the csv-file
     * @throws IOException when something goes wrong
     */
    public void writeToStream(List<T> dataList, OutputStream stream) throws IOException {

        for (T data : dataList) {

            writeToStream(data, stream);
        }
    }

    /**
     * Writes a data comma-separated in a stream
     *
     * @param data   the data to write in the csv-file
     * @param stream the target output-stream for the csv-file
     * @throws IOException when something goes wrong
     */
    public void writeToStream(T data, OutputStream stream) throws IOException {

        // get orders from annotations
        HashMap<Integer, Field> fields = getAnnotatedFields(data.getClass());

        // write field values in order
        writeFieldValues(stream, data, fields, DEFAULT_START_INDEX);

        this.write(CSV_LINE_SEPARATOR, stream);
    }

    /**
     * Determines the annotated fields on a class
     *
     * @param dataClass: the csv bean
     * @return the annotated fields of the class
     */
    private HashMap<Integer, Field> getAnnotatedFields(Class<? extends Object> dataClass) {

        HashMap<Integer, Field> fields = new HashMap<>();
        for (Field field : dataClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(CsvEntry.class)) {
                CsvEntry annotation = field.getAnnotation(CsvEntry.class);

                int fieldIndex = annotation.value();
                fields.put(fieldIndex, field);
            }
        }
        return fields;
    }

    /**
     * Writes the field values in the output-stream
     *
     * @param stream        outputStream to write in
     * @param data          the data-object which contains the actual information
     * @param fieldsToWrite the declared fields of the class
     * @param startIndex    the first index to write in
     * @throws IOException when something goes wrong
     */
    private void writeFieldValues(OutputStream stream, T data, HashMap<Integer, Field> fieldsToWrite, int startIndex) throws IOException {

        for (int i = startIndex; i <= fieldsToWrite.size(); ++i) {

            Field field = fieldsToWrite.get(i);

            if (field == null) {
                continue;
            }

            field.setAccessible(true);
            try {
                Object fieldValue = field.get(data);

                if (field.isAnnotationPresent(CsvTransform.class)) {
                    CsvTransform transform = field.getAnnotation(CsvTransform.class);
                    CsvTransformer transformerInstance = transform.value().newInstance();
                    fieldValue = transformerInstance.transform(fieldValue);
                }
                this.write(fieldValue, stream);
                this.write(CSV_COLUMN_SEPARATOR, stream);
            } catch (Exception e) {
                LOGGER.error(e, e);
            }
        }
    }

    /**
     * @param value the value to write
     * @param out   output-stream to write in
     * @throws IOException when something goes wrong
     */
    private void write(Object value, OutputStream out) throws IOException {

        out.write(value == null ? "".getBytes(ENCODING) : value.toString().getBytes(ENCODING));
    }
}