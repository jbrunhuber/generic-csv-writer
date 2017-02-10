# generic-csv-writer
A simple CSV-writing library

[![Build status](https://ci.appveyor.com/api/projects/status/2h5w5tbbixyv4vcm?svg=true)](https://ci.appveyor.com/project/jbrunhuber/generic-csv-writer)

## Export a CSV File

Annotate the attribute which you want to export with @CsvEntry. The parameter sets the index-location in the csv-file.

```java
/**
 *
 */
class Bean {

    @CsvEntry(0)
    String name;

    @CsvEntry(1)
    String homeCountry;

    @CsvEntry(2)
    float price;
}
```

## Use existing transformer

Currently are three transformers available:

- **UmlautTransformer.class:** Transforms umlauts to prevent encoding problems
- **EscapeTransformer.class:** Escapes a text which contains a CSV-Separator
- **BooleanToIntegerTransformer.class:** Converts a boolean value to a int value (true will be 1)
	
Annotate the attribute which you want to transform with @CsvTransform. Give the class of the specific transformer which you want to use. 

```java
    @CsvEntry(8)
    @CsvTransform(BooleanToIntegerTransformer.class)
    boolean present;
```

## Write your own transformer

Write a class which implements 'Transformable'. Override the 'transform'-method and implement your stuff.
You can use your transformer the same way like the existing transformers. 

public class MagicUnicornTransformer implements Transformable {

```java
public class MagicUnicornTransformer implements Transformable {
    /**
     *
     */
    @Override
    public String transform(Object o) {

        // magic goes here...
    }
}
```
