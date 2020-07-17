package com.aaa.wkn.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
/**
 * @author Weather
 * @Company AAA德云社
 * @date 2020/7/16 8:57
 */
public class JSONUtils {
    // 1.定义私有静态常量ObjectMapper(命名规则：所有字母全部大写，单词与单词之间使用_连接)
    // ObjectMapper:就是fastjson包中进行类型转换的工具类
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     *
     * @param object
     * @return
     */
    public static String toJsonString(Object object) {
        try {
            String jsonString = OBJECT_MAPPER.writeValueAsString(object);
            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param jsonData
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> T toObject(String jsonData, Class<T> beanType) {
        try {
            T t = OBJECT_MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param jsonData
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(String jsonData, Class<T> beanType) {
        // 1.为List集合添加一个指定的泛型
        // List  User.class ---> 通过constructParametricType方法把List和User合并，也就是说为List指定一个User对象的泛型(List<User>)
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = OBJECT_MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
