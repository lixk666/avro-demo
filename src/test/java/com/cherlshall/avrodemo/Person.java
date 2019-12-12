package com.cherlshall.avrodemo;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static javax.xml.datatype.DatatypeFactory.newInstance;

public class Person {
private String name;
private int age;

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
public void run(){
System.out.println(name+"正在 Running!");
}
}
//使用反射和内省操作:





// //反射方法
//         @Test
// public void test3() throws Exception{
//  Class clazz = Class.forName("cn.ouyang.test.entity.Person");
//  Object obj = clazz.newInstance();
//  System.out.println(obj);
//  Constructor duixiangObject=clazz.getConstructor(new Class[]{String.class,int.class});
//  Object nobj=duixiangObject.newInstance(new Object[]{"ddd",22});
//  Field field=clazz.getDeclaredField("name");
//  field.setAccessible(true);//暴力反射(获得权限)
//  System.out.println(field);
//  //设置值
//  field.set(nobj, "dddd");
//  System.out.println(field.get(nobj));
//  //得到方法
//  Method method=clazz.getMethod("run", new Class[]{});
//  System.out.println(method.getReturnType());
//  method.invoke(nobj, null);
//  //得到静态方法
//  Method stMethod=clazz.getMethod("running", null);
//  stMethod.invoke(null, null);
// }
// //动态创建数组1
//         @Test
// public void test4() throws Exception{
//  Class clazz=Class.forName("java.lang.Integer");
//  Object arr=Array.newInstance(clazz,10);
//  Array.set(arr, 5, 12);
//  System.out.println(Array.get(arr, 5));
// }
// //动态创建数组2（三维数组）
//         @Test
// public void test5() throws Exception{
//  Class clazz=Class.forName("java.lang.Integer");
//  int[] myshuzu={20,22,32};
//  Object arr=Array.newInstance(clazz,myshuzu);
//  Object arr1=Array.get(arr, 1);
//  System.out.println(arr1);//x
//  Object arr2=Array.get(arr1, 2);
//  System.out.println(arr2);//y
//  Array.set(arr2, 3, 88);
//  System.out.println(Array.get(arr2, 3));//z
// }
