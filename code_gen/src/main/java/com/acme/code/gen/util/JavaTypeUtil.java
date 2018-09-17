package com.acme.code.gen.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * javaType与jdbcType之间互相转换
 *
 * @author H
 */
public class JavaTypeUtil {
    /**
     * jdbc type 对应的java的type
     */
    public static Map<Integer, Class<?>> jdbc2JavaClass = new HashMap<>(16);

    /**
     * jdbc 生成 pojo使用
     */
    public static Map<Integer, String> mapping = new HashMap<>(16);

    public static Map<String, Integer> jdbcTypeNames = new HashMap<>(16);

    public static int JDK_NUMBER = 15;
    public static final int JDK_8 = 18;
    public final static String UNKNOW = "UNKNOW";
    public final static String SPECIAL = "SPECIAL";

    static {
        String javaVersion = System.getProperty("java.version");
        if (javaVersion.contains("1.9.")) {
            JDK_NUMBER = 19;
        } else if (javaVersion.contains("1.8.")) {
            JDK_NUMBER = 18;
        } else if (javaVersion.contains("1.7.")) {
            JDK_NUMBER = 17;
        } else if (javaVersion.contains("1.6.")) {
            JDK_NUMBER = 16;
        } else {
            // else leave 1.5 as default (it's either 1.5 or unknown)
            JDK_NUMBER = 15;
        }
    }


    static {
        // 初始化jdbcJavaTypes：
        // -16
        jdbc2JavaClass.put(Types.LONGNVARCHAR, String.class);
        // 字符串
        // -15 字符串
        jdbc2JavaClass.put(Types.NCHAR, String.class);
        // -9 字符串
        jdbc2JavaClass.put(Types.NVARCHAR, String.class);
        // -8 字符串
        jdbc2JavaClass.put(Types.ROWID, String.class);
        // -7 布尔
        jdbc2JavaClass.put(Types.BIT, Boolean.class);
        // -6 数字
        jdbc2JavaClass.put(Types.TINYINT, Integer.class);
        // -5 数字
        jdbc2JavaClass.put(Types.BIGINT, Long.class);
        // -4
        jdbc2JavaClass.put(Types.LONGVARBINARY, byte[].class);
        // 二进制
        // -3 二进制
        jdbc2JavaClass.put(Types.VARBINARY, byte[].class);
        // -2 二进制
        jdbc2JavaClass.put(Types.BINARY, byte[].class);
        // -1
        jdbc2JavaClass.put(Types.LONGVARCHAR, String.class);
        // 字符串
        // 1 字符串
        jdbc2JavaClass.put(Types.CHAR, String.class);
        // 2 数字
        jdbc2JavaClass.put(Types.NUMERIC, BigDecimal.class);
        // 3 数字
        jdbc2JavaClass.put(Types.DECIMAL, BigDecimal.class);
        // 4 数字
        jdbc2JavaClass.put(Types.INTEGER, Integer.class);
        // 5 数字
        jdbc2JavaClass.put(Types.SMALLINT, Integer.class);
        // 6 数字
        jdbc2JavaClass.put(Types.FLOAT, BigDecimal.class);
        // 7 数字
        jdbc2JavaClass.put(Types.REAL, BigDecimal.class);
        // 8 数字
        jdbc2JavaClass.put(Types.DOUBLE, BigDecimal.class);
        // 12 字符串
        jdbc2JavaClass.put(Types.VARCHAR, String.class);
        // 16 布尔
        jdbc2JavaClass.put(Types.BOOLEAN, Boolean.class);
        // 91 日期
        jdbc2JavaClass.put(Types.DATE, Date.class);
        // 92 日期
        jdbc2JavaClass.put(Types.TIME, Time.class);
        // 93 DATETIME 日期 直接使用LocalDateTime
        jdbc2JavaClass.put(Types.TIMESTAMP, LocalDateTime.class);

        // 1111 其他类型？
        jdbc2JavaClass.put(Types.OTHER, Object.class);
        // 2004 二进制
        jdbc2JavaClass.put(Types.BLOB, byte[].class);
        // 2005 大文本
        jdbc2JavaClass.put(Types.CLOB, String.class);
        // 2009
        jdbc2JavaClass.put(Types.SQLXML, SQLXML.class);
        // 2011 大文本
        jdbc2JavaClass.put(Types.NCLOB, String.class);
    }


    static {
        mapping.put(Types.BIGINT, "Long");
        mapping.put(Types.BINARY, "byte[]");
        mapping.put(Types.BIT, "Integer");
        mapping.put(Types.BLOB, "byte[]");
        mapping.put(Types.BOOLEAN, "Integer");
        mapping.put(Types.CHAR, "String");
        mapping.put(Types.CLOB, "String");
        mapping.put(Types.DATALINK, UNKNOW);
        mapping.put(Types.DATE, "Date");
        mapping.put(Types.DECIMAL, "SPECIAL");
        mapping.put(Types.DISTINCT, UNKNOW);
        mapping.put(Types.DOUBLE, "Double");
        mapping.put(Types.FLOAT, "Float");
        mapping.put(Types.INTEGER, "Integer");
        mapping.put(Types.JAVA_OBJECT, UNKNOW);
        mapping.put(Types.LONGNVARCHAR, "String");
        mapping.put(Types.LONGVARBINARY, "byte[]");
        mapping.put(Types.LONGVARCHAR, "String");
        mapping.put(Types.NCHAR, "String");
        mapping.put(Types.NVARCHAR, "String");
        mapping.put(Types.NCLOB, "String");
        mapping.put(Types.NULL, UNKNOW);
        mapping.put(Types.NUMERIC, SPECIAL);
        mapping.put(Types.OTHER, "Object");
        mapping.put(Types.REAL, "Double");
        mapping.put(Types.REF, UNKNOW);
        mapping.put(Types.SMALLINT, "Integer");
        mapping.put(Types.SQLXML, "SQLXML");
        mapping.put(Types.STRUCT, UNKNOW);
        mapping.put(Types.TIME, "Date");
        mapping.put(Types.TIMESTAMP, "LocalDateTime");
        mapping.put(Types.TINYINT, "Integer");
        mapping.put(Types.VARBINARY, "byte[]");
        mapping.put(Types.VARCHAR, "String");

        // jdk 8 support
        if (JDK_NUMBER >= JDK_8) {
            mapping.put(Types.REF_CURSOR, UNKNOW);
            mapping.put(Types.TIMESTAMP_WITH_TIMEZONE, "Timestamp");
            mapping.put(Types.TIME_WITH_TIMEZONE, "Timestamp");
        }

    }


    static {
        Field[] fields = java.sql.Types.class.getFields();
        for (int i = 0, len = fields.length; i < len; ++i) {
            if (Modifier.isStatic(fields[i].getModifiers())) {
                try {
                    String name = fields[i].getName().toLowerCase();
                    Integer value = (Integer) fields[i].get(java.sql.Types.class);
                    jdbcTypeNames.put(name, value);

                } catch (IllegalArgumentException | IllegalAccessException e) {
                    //不可能发生
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean isDateType(Integer sqlType) {
        // 日期类型有特殊操作
        if (sqlType == Types.DATE || sqlType == Types.TIME || sqlType == Types.TIME_WITH_TIMEZONE
                || sqlType == Types.TIMESTAMP || sqlType == Types.TIMESTAMP_WITH_TIMEZONE) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isInteger(Integer sqlType) {
        if (sqlType == Types.BOOLEAN || sqlType == Types.BIT || sqlType == Types.INTEGER || sqlType == Types.TINYINT
                || sqlType == Types.SMALLINT) {
            return true;
        } else {
            return false;
        }
    }

    public static String getType(Integer jdbcDataType, Integer size, Integer digit) {
        String type = mapping.get(jdbcDataType);
        if (type.equals(SPECIAL)) {
            if (digit != null && digit != 0) {
                return "Double";
            } else {
                // 有可能是BigInt，但先忽略，这种情况很少，用户也可以手工改
                if (size >= 9) {
                    return "Long";
                } else {
                    return "Integer";
                }
            }
        } else {
            return type;
        }
    }


    public static boolean isJavaNumberType(int jdbcType) {
        Class<?> type = jdbc2JavaClass.get(jdbcType);
        return (type != null) && (Number.class.isAssignableFrom(type));
    }

    public static boolean isJdk8() {
        return JDK_NUMBER >= 18;
    }

}
