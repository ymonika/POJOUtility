package com.example.service;

import com.example.utils.Util;

public class GetterSetter {

    private String varName;
    private String varType;

    public GetterSetter(String varName, String varType) {
        this.varName = varName;
        this.varType = varType;
    }

    public String getter() {
        return "\npublic " + varType + " get" + Util.camelCaseVariable(varName) + "() { return " + varName + "; }";
    }

    public String setter() {
        return "\npublic void set" + Util.camelCaseVariable(varName) + "(" + varType + " " + varName + ") { this." + varName + "=" + varName + "; }";
    }

    public String getVariableDeclaration() {
        return "private " + varType + " " + varName + ";";
    }

    @Override
    public String toString() {
        return getVariableDeclaration() + "\n" + getter() + "\n" + setter();
    }
}
