package com.example.utils;

public class Util {

    public static String camelCaseVariable(String varName) {
        StringBuffer camelCaseVarName = new StringBuffer();
        camelCaseVarName.append(varName.substring(0, 1).toUpperCase());
        camelCaseVarName.append(varName.substring(1));
        return camelCaseVarName.toString();
    }
}
