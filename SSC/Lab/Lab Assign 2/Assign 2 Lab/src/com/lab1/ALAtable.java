package com.lab1;

import java.util.LinkedHashMap;

public class ALAtable {
    private static LinkedHashMap<String, String> ALA = new LinkedHashMap<String, String>();
    private static int index = 0;

    public static void add(String arguments) {
        index++;
        ALA.put(Integer.toString(index), arguments);
    }
    
    public static void printALA() {
        System.out.println("Index" + "\t" + "Formal Arguments");
        System.out.println("------------------------------------------");
        for (String key : ALA.keySet()) {
            System.out.println(key + "\t" + ALA.get(key));
        }
        System.out.println();
    }

    public static LinkedHashMap<String, String> getALA() {
        return ALA;
    }
    
}
