package com.example.service;

import com.example.utils.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class OuterClass {

    private String className;
    private List<GetterSetter> getterSetters;
    private List<String> variableList;

    public OuterClass(String className) {
        this.className = Util.camelCaseVariable(className);
        getterSetters = new ArrayList<>();
        variableList = new ArrayList<>();
    }

    public String getClassName() {
        return className;
    }

    public void addGetterSetters(GetterSetter getterSetter) {
        this.getterSetters.add(getterSetter);
    }

    public void addVariableList(String variableDeclaration) {
        this.variableList.add(variableDeclaration);
    }

    @Override
    public String toString() {
        StringJoiner getterStringJoiner = new StringJoiner("\n");
        getterSetters.forEach(getterSetter -> getterStringJoiner.add(getterSetter.getter() +"\n"+ getterSetter.setter()));
        StringJoiner variableListStringJoiner = new StringJoiner("\n");
        variableList.forEach(var -> variableListStringJoiner.add(var));

        return "public class "+ Util.camelCaseVariable(className) + " {\n" +
                variableListStringJoiner.toString() +
                getterStringJoiner.toString()
                + "\n}";
    }
}
