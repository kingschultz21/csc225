import java.io.*;
import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class P5V00872923 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int mode = 0;
        HashMap<String,Integer> table = new HashMap<>(n * 2);
        for(int i = 0; i < n; i++){
            String key = input.next();
            if(table.containsKey(key)){
                mode = table.get(key);
                mode++;
                table.put(key,mode);
            }else{
                table.put(key,1);
            }
        } 
        int max_count = 0;
        String res = ""; 
        
        /*
        *   https://www.geeksforgeeks.org/frequent-element-array/
        *   Some logic and ideas were used in the implentation below
        */
        for(HashMap.Entry<String, Integer> val : table.entrySet()) 
        { 
            if (max_count < val.getValue()) 
            { 
                res = val.getKey(); 
                max_count = val.getValue(); 
            } 
        }
        table.remove(res,max_count);
        String res2 = "";
        for(HashMap.Entry<String, Integer> val : table.entrySet()) 
        { 
            if (max_count == val.getValue()) 
            { 
                res2 = val.getKey(); 
                max_count = val.getValue(); 
            } 
        }
        if(!res2.equals("")){
             if(res.compareTo(res2) < 0)
                System.out.println(res+ " "+max_count);
             else
                System.out.println(res2+ " "+max_count);
        }else{
            System.out.println(res+ " "+max_count);
        }
    }       
}