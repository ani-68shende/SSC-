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

public class Pass2_MACRO {
    public static void printPass2_MACRO() {
        System.out.println("Pass2 MACRO :\n");
        File file = new File("src/com/lab1/output_file.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileWriter xyz;
        try
        {
            xyz = new FileWriter("src/com/lab1/new_output_pass2.txt");
            BufferedWriter writer2 = new BufferedWriter(xyz);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                StringTokenizer st = new StringTokenizer(line, " ");
                String opcode = st.nextToken();
                if (MNTtable.isMacro_present(opcode)) {
                        String str = line;
                        String[] list1 = str.split(" ");
                        
                        //fetching the arguemnts of the macro
                        ArrayList<String> arguments_of_macro = Pass1_MACRO.getMacro_with_their_params(list1[0]);
                        int j = 0;
                        LinkedHashMap<String, String> temp_map = new LinkedHashMap<String, String>();
                        for (int i = 1; i < list1.length; i++) {
                            temp_map.put(arguments_of_macro.get(j), list1[i]);
                            j++;
                        }
                
;                        //replacing the arguments with the values
                        int j1 = 0;
                        for (int i = 1; i < list1.length; i++) {
                            for (String key : ALAtable.getALA().keySet()) {
                                if (ALAtable.getALA().get(key).equals(arguments_of_macro.get(j1))) {
                                    ALAtable.getALA().put(key, list1[i]);
                                    j1++;
                                    break;
                                }
                            }
                        }
                        
                        //reading the code for extracting the macro
                        File file1 = new File("src/com/lab1/input1.txt");
                        Scanner sc1 = null;
                        try {
                            sc1 = new Scanner(file1);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        while (sc1.hasNextLine()) {
                            String line1 = sc1.nextLine();
                            StringTokenizer st1 = new StringTokenizer(line1, " ");
                            String opcode1 = st1.nextToken();
                            if (opcode1.equals("MACRO")) {
                                String str1 = sc1.nextLine();
                                String[] list4 = str1.split(" ");
                                
                                if (MNTtable.isMacro_present(opcode) && list4[0].equals(opcode)) {
                                    str1 = sc1.nextLine();
                                    while (!str1.equals("MEND")) {
                                        String[] list2 = str1.split(" ");
                                        for (int i = 0; i < list2.length; i++) {
                                            if (temp_map.containsKey(list2[i])) {
                                                list2[i] = temp_map.get(list2[i]);
                                            }
                                        }
                                        String fina = "+";
                                        for (int i = 0; i < list2.length; i++) {
                                            fina = fina + list2[i] + " ";
                                        }
                                        //System.out.println(fina);
                                        writer2.write(fina);
                                        writer2.newLine();
                                        str1 = sc1.nextLine();
                                    }
                                }
                            }
                        }
                        // sc.nextLine();
                    } else {
                        writer2.write(line);
                        writer2.newLine();
                    }
            }
            writer2.close();
        }
        catch (IOException except)
        {
            except.printStackTrace();
        }
        System.out.println("\n\nUpdated ALA Table : \n");
        ALAtable.printALA();
        sc.close();
    }
}

