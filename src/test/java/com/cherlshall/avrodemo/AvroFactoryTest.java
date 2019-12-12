package com.cherlshall.avrodemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.junit.Test;
import tech.allegro.schema.json2avro.converter.JsonAvroConverter;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hu.tengfei
 * @date 2019/8/9
 */
public class AvroFactoryTest {

    @Test
    public void test() throws IOException {
        String schemaJson = "{" +
                "   \"type\": \"record\"," +
                "   \"name\": \"user\"," +
                "   \"fields\": [" +
                "       {" +
                "           \"name\": \"name\"," +
                "           \"type\": [\"null\", \"string\"]" +
                "       }," +
                "       {" +
                "           \"name\": \"age\"," +
                "           \"type\": [\"null\", \"int\"]" +
                "       }," +
                "       {" +
                "           \"name\": \"gender\"," +
                "           \"type\": [\"null\", \"boolean\"]" +
                "       }" +
                "   ]" +
                "}";

        String schemaJson1 = "{" +
                "   \"type\": \"record\"," +
                "   \"name\": \"user\"," +
                "   \"fields\": [" +
                "       {" +
                "           \"name\": \"name\"," +
                "           \"type\": [\"null\", \"string\"]" +
                "       }," +
                "       {" +
                "           \"name\": \"age\"," +
                "           \"type\": [\"null\", \"int\"]" +
                "       }," +
                "       {" +
                "           \"name\": \"gender\"," +
                "           \"type\": [\"null\", \"boolean\"]" +
                "       }," +
                "       {" +
                "           \"name\": \"job\"," +
                "           \"type\": [\"null\", \"string\"]" +
                "       }" +
                "   ]" +
                "}";
//        String schemaJson =
//                "{" +
//                        "   \"type\" : \"record\"," +
//                        "   \"name\" : \"Acme\"," +
//                        "   \"fields\" : [{ \"name\" : \"username\", \"type\" : \"string\" }]" +
//                        "}";
//
//
        User user = new User();
        user.setAge(18);
        user.setName("xiaoming");
        user.setGender(true);
        user.setJob("teacher");

        String json = JSON.toJSONString(user);
        System.out.println("json串是 \n" +json);

//        String json = "{ \"username\": \"mike\" }";

//        Schema schema = new Schema.Parser().parse(schemaJson);
        JsonAvroConverter converter = new JsonAvroConverter();

        byte[] bytes1 = converter.convertToAvro(json.getBytes(), schemaJson1);
        System.out.println("字节数组是");
       for (int i =0;i<bytes1.length;i++){
           System.out.print(bytes1[i] + " ");
       }
        byte[] bytesavro = converter.convertToJson(bytes1, schemaJson1);
        System.out.println("\n字符串是");

        java.lang.String jsonString = new java.lang.String(bytesavro);
        System.out.println(jsonString);

        JSONObject jsonObject = JSON.parseObject(jsonString);
        System.out.println(jsonObject.get("gender").getClass());

    }
}
class User {
    private String name="";
    private int age;
    private boolean gender;
    private String job="";

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

}