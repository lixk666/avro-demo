package com.cherlshall.avrodemo;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import tech.allegro.schema.json2avro.converter.AvroConversionException;
import tech.allegro.schema.json2avro.converter.JsonAvroConverter;

public class TestAvro {
    public static void main(String[] args) {
        String schema =
                "{" +
                        "   \"type\" : \"record\"," +
                        "   \"name\" : \"Acme\"," +
                        "   \"fields\" : [{ \"name\" : \"username\", \"type\" : \"string\" }]" +
                        "}";

        String json = "{ \"username\": \"mike\" }";

        JsonAvroConverter converter = new JsonAvroConverter();

// conversion to binary Avro
        byte[] avro = converter.convertToAvro(json.getBytes(), schema);

// conversion to GenericData.Record
        GenericData.Record record = converter.convertToGenericDataRecord(json.getBytes(), new Schema.Parser().parse(schema));

// conversion from binary Avro to JSON
        byte[] binaryJson = converter.convertToJson(avro, schema);

// exception handling
        String invalidJson = "{ \"username\": 8 }";

        try {
            converter.convertToAvro(invalidJson.getBytes(), schema);
        } catch (AvroConversionException ex) {
            System.err.println("Caught exception: " + ex.getMessage());
        }
    }
}
