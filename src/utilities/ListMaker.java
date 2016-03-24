package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class ListMaker {

    public ListMaker() {

    }

    
    // save lists
    // compare generic to primitive
    public static Integer[] makeIntList(int size, int range) {
        Random randy = new Random();
	Integer[] intlist = new Integer[size];
	for (int i = 0; i < size; i++) {
            intlist[i] = randy.nextInt(range+1);
        }
	return intlist;
    }
    
    public static Integer[] readCSV(String name) {
        Integer[] list = new Integer[0];
        ArrayList<Integer> aint = new ArrayList();
        String n = new File(name).getAbsolutePath();
        try {
            BufferedReader br = new BufferedReader(new FileReader(n));
            String[] values = br.readLine().split(",");
            list = new Integer[values.length];
            for (int i = 0; i < values.length; i++) {
                list[i] = Integer.parseInt(values[i].substring(1, values[i].length()-1));
                
            }
            System.out.println(list.length);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public static void exportCSV(int size, int range, String name){
        Random randy = new Random();
	Integer[] intlist = new Integer[size];
	for (int i = 0; i < size; i++) {
            intlist[i] = randy.nextInt(range+1);
        }
        try (PrintWriter print = new PrintWriter(new File(name))) {
            for (int i = 0; i < size; i++) {
                if (i == size-1) {
                    print.append("\"" + intlist[i] + "\"");                    
                } else {
                    print.append("\"" + intlist[i] + "\",");                    
                }

            }
        } catch (FileNotFoundException e) {
           
        }

    }
    
}
