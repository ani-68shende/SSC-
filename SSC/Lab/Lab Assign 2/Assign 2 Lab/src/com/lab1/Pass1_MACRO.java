package com.lab1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Pass1_MACRO {
    private static LinkedHashMap<String, ArrayList<String>> macro_with_their_params = new LinkedHashMap<String, ArrayList<String>>();

    public static void printPass1_MACRO() {
        System.out.println("Pass1 MACRO : ");
        File file = new File("src/com/lab1/input1.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            String opcode = st.nextToken();
            if (opcode.equals("MACRO")) {
                String str = sc.nextLine();
                MDTtable.add(str);
                int counter = 0;
                while (!str.equals("MEND")) {
                    if (counter == 0) {
                        String[] list1 = str.split(" ");
                        MNTtable.add_to_MNT(list1[0], MDTtable.getLocation_counter());
                        ArrayList<String> list2 = new ArrayList<String>();
                        for (int i = 1; i < list1.length; i++) {
                            list2.add(list1[i]);
                            ALAtable.add(list1[i]);
                        }
                        macro_with_their_params.put(list1[0], list2);
                    }
                    counter++;
                    str = sc.nextLine();
                    MDTtable.add(str);
                }
            } else {
                FileWriter abc;
                try {
                    abc = new FileWriter("src/com/lab1/output_file.txt");
                    BufferedWriter writer = new BufferedWriter(abc);
                    writer.write(line);
                    writer.newLine();
                    while (sc.hasNextLine()) {
                        String line1 = sc.nextLine();
                        writer.write(line1);
                        writer.newLine();
                    }
                    writer.close();
                } catch (IOException except) {
                    except.printStackTrace();
                }
            }
        }
        System.out.println("\n\nMDT Table : \n");
        MDTtable.printMDT();
        System.out.println("\n\nMNT Table : \n");
        MNTtable.printMNT();
        System.out.println("\n\nALA Table : \n");
        ALAtable.printALA();
        sc.close();

    }
    
    public static ArrayList<String> getMacro_with_their_params(String macro_name) {
        return macro_with_their_params.get(macro_name);
    }
}
