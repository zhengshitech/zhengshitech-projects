package com.acme.code.gen.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author H
 */
public class StringKitUtil {

    public static String replaceUnderLineAndUpperCase(String str) {
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while (count != 0) {
            int num = sb.indexOf("_", count);
            count = num + 1;
            if (num != -1) {
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count, count + 1, ia + "");
            }
        }
        String result = sb.toString().replaceAll("_", "");
        return StringUtils.capitalize(result);
    }

    public static void main(String[] args) {
        lowerCaseFirstLetter("ThisIsMe");
    }

    public static String lowerCaseFirstLetter(String word) {
        if (StringUtils.isEmpty(word)) {
            return word;
        }
        return word.substring(0, 1).toLowerCase() + word.substring(1);
    }

    public static String upperCaseFirstLetter(String word) {
        if (StringUtils.isEmpty(word)) {
            return word;
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    private String getMethodName(String name){
        if(name.length()==1){
            return name.toUpperCase();
        }
        char ch1 = name.charAt(0);
        char ch2 = name.charAt(1);
        if(Character.isLowerCase(ch1)&&Character.isUpperCase(ch2)){
            //aUname---> getaUname();
            return name;
        }else if(Character.isUpperCase(ch1)&&Character.isUpperCase(ch2)){
            //ULR --> getURL();
            return name ;
        }else{
            //general  name --> getName()
            char upper = Character.toUpperCase(ch1);
            return upper+name.substring(1);
        }
    }

}
