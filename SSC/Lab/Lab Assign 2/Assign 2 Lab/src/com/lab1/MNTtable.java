package com.lab1;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class MNTtable {
    private static LinkedHashMap<String, String> MNT = new LinkedHashMap<String, String>();
    private static Set<String> all_macros = new HashSet<String>();
    
    public static void add_to_MNT(String macro_name, int index) {
        all_macros.add(macro_name);
        MNT.put(macro_name,Integer.toString(index));
    }

    public static void printMNT() {
        int mnt_index = 0;
        System.out.println("MNT Index" + "\t" + "Macro Name" + "\t" + "MDT Index");
        System.out.println("------------------------------------------");
        for (String key : MNT.keySet()) {
            mnt_index++;
            System.out.println(mnt_index + "\t\t" + key + "\t\t" + MNT.get(key));
        }
    }

    public static boolean isMacro_present(String macro_name) {
        return all_macros.contains(macro_name);
    }
}
