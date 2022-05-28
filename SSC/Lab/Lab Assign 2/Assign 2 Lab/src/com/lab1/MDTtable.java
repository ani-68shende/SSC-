package com.lab1;

import java.util.LinkedHashMap;

public class MDTtable {
    private static int location_counter = 0;
    private static LinkedHashMap<String, String> MDT = new LinkedHashMap<String, String>();

    public static int getLocation_counter() {
        return location_counter;
    }
    
    public static void add(String instructions) {
        location_counter += 1;
        MDT.put(Integer.toString(location_counter), instructions);
    }

    public static void printMDT() {
        System.out.println("Index" + "\t" + "Instructions");
        System.out.println("------------------------------------------");
        for (String key : MDT.keySet()) {
            System.out.println(key + "\t" + MDT.get(key));
        }
    }
}
