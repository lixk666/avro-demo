package com.cherlshall.avrodemo;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test1 {

        // JAVA中的内省
        @Test
        public void test() throws Exception {
            Object obj = Class.forName("com.cherlshall.avrodemo.Person")
                    .newInstance();
            BeanInfo bf = Introspector.getBeanInfo(obj.getClass(), Object.class);
            PropertyDescriptor[] pds = bf.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                System.out.println("属性" + pd.getName());
                if (pd.getName().equals("name")) {
                    pd.getWriteMethod().invoke(obj, "小明");
                }
            }
            MethodDescriptor[] mds = bf.getMethodDescriptors();
            for (MethodDescriptor md : mds) {
                System.out.println("方法" + md.getName());
                Method method = md.getMethod();
                if (method.getName().equals("run")) {
                    method.invoke(obj, null);
                }
            }
        }

        // JAVA中的反射
        @Test
        public void test1() throws Exception {
            Class clazz = Class.forName("com.cherlshall.avrodemo.Person");
            Object obj = clazz.newInstance();
            System.out.println("所有方法");
            Method[] mds = clazz.getDeclaredMethods();
            for (Method method : mds) {
                System.out.println(method.getName());
            }
            System.out.println("所有属性");
            Field[] filds = clazz.getDeclaredFields();
            for (Field field : filds) {

                System.out.println(field.getName());
            }
            System.out.println("构造函数");
            Constructor[] cs=clazz.getConstructors();
            for (Constructor constructor : cs) {
                System.out.println(constructor.getName());
            }
            System.out.println(clazz.getConstructor(null));//单个
            System.out.println("super类");
            System.out.println(clazz.getSuperclass());
        }
}
