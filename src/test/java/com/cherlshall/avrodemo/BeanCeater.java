package com.cherlshall.avrodemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;
import org.apache.avro.JsonProperties;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangpengzhi1 on 2018/1/2.
 */
public class BeanCeater {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        System.out.println("Generate JavaBean");
        Map properties = new HashMap();
        properties.put("id", Class.forName("java.lang.Integer"));
        properties.put("name", Class.forName("java.lang.String"));
        properties.put("address", Class.forName("java.lang.String"));
        properties.put("key",Class.forName("java.lang.String"));
        Object stu = generateObject(properties);


        String json = "{\"name\":\"jack\"}";
        Object user = JSON.parseObject(json, stu.getClass());



        String jsonString = JSON.toJSONString(user);

        System.out.println(jsonString);


        System.out.println("====================================");

        Method setName = user.getClass().getDeclaredMethod("setName", String.class);

        setName.invoke(user,"tom");

        System.out.println("====================================");

        Method getName = user.getClass().getDeclaredMethod("getName", null);

        System.out.println(getName.invoke(user));

//        System.out.println("Show all methods");
//        Method[] methods = user.getClass().getDeclaredMethods();
//        for(Method method : methods) {
//            if(method.getName().equals("getName")){
//                System.out.println(method.invoke(user));
//            }
////            System.out.println(">> " + method.getName());
//        }

//        System.out.println(user.getClass().getDeclaredMethods());


/*        System.out.println("Set values");
        setValue(stu, "id", 123);
        setValue(stu, "name", "454");
        setValue(stu, "address", "789");
        setValue(stu,"key","101");
        System.out.println("Get values");
        System.out.println(">> " + getValue(stu, "id"));
        System.out.println(">> " + getValue(stu, "name"));
        System.out.println(">> " + getValue(stu, "address"));

        System.out.println("Show all methods");
        Method[] methods = stu.getClass().getDeclaredMethods();
        for(Method method : methods) {
            if(method.getName().equals("getId")){
                System.out.println(method.invoke(stu));
            }
            System.out.println(">> " + method.getName());
        }

        System.out.println("Show all properties");
        Field[] fields = stu.getClass().getDeclaredFields();
        for(Field field : fields) {
            System.out.println(">> " + field.getName());
        }*/

//        System.out.println(getValue(stu,"id"));
//        System.out.println(stu);
    }

    private static Object generateObject(Map properties) {
        BeanGenerator generator = new BeanGenerator();
        Set keySet = properties.keySet();
        for(Iterator i = keySet.iterator(); i.hasNext();) {
            String key = (String)i.next();
            generator.addProperty(key, (Class)properties.get(key));
        }
        return generator.create();
    }

    private static Object getValue(Object obj, String property) {
        BeanMap beanMap = BeanMap.create(obj);
        return beanMap.get(property);
    }

    private static void setValue(Object obj, String property, Object value) {
        BeanMap beanMap = BeanMap.create(obj);
        beanMap.put(property, value);
    }
}

