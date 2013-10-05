package org.suurhans.algorithms.parser;

import java.util.Stack;

public class PrettyJSON {

    public static String prettify(String json) {

        if (json == null)
            return "";

        if (json.charAt(0) != '{' || json.charAt(json.length() - 1) != '}')
            throw new IllegalArgumentException("Not a valid JSON string");



        return "";
    }

    public static void main(String[] args) {

        //String json = "{'firstName':'John','age':25,'address':{'streetAddress':'21 2nd Street'},'phones':[{'number':123},{'number':123}],'array':[1,2,3]}";
        String json = "{'firstname':'John','age'    :   25}";

        System.out.println(prettify(json));
    }

}
