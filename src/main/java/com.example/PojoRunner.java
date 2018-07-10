package com.example;

import com.example.service.GetterSetter;
import com.example.service.OuterClass;

import java.io.*;

public class PojoRunner {

    public static void main(String[] args) throws IOException {

        String currentDir = System.getProperty("user.dir");
        String resourceDir = "/src/main/resources/";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(currentDir + resourceDir + "input.txt"));

        String className = bufferedReader.readLine();
        OuterClass outerClass = new OuterClass(className);

        bufferedReader.lines().forEach(readLine -> {
            String[] array = readLine.split(" ");
            if (array.length > 1) {
                GetterSetter getterSetter = new GetterSetter(array[0], array[1]);
                outerClass.addGetterSetters(getterSetter);
                outerClass.addVariableList(getterSetter.getVariableDeclaration());
            }
        });

        File file = new File(currentDir + resourceDir + outerClass.getClassName() + ".java");

        FileWriter writer = new FileWriter(file);
        writer.write(outerClass.toString());
        writer.close();

        System.out.println("Please find "+outerClass.getClassName()+".java at: " + file );
    }


}
