import java.io.*;
import java.util.*;

public class P1V00872923 {
    public static void main(String[] args) {
        //Scanner setup for input
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] values = new int[n];
        
        //Obtain values from stdin
        for(int i = 0; i < n; i++){
            values[i] = input.nextInt();
        }
        //Function call
        int result[] = findDifference(values);
        System.out.print(result[0]+" "+result[1]);
    }
    /*
    * Returns an array of 2 elements
    * These elements contain the smallest difference from the input
    * Parameter: array of integers
    */
    public static int[] findDifference(int[] vals){
        Arrays.sort(vals);
        int[] result = {vals[0],vals[1]};
        int i = 0;
        for(; i < vals.length-1; i++){
            //Logic pertaining to assignment rules
            if(Math.abs(vals[i] - vals[i+1]) <= Math.abs(result[0] - result[1])){
                if(Math.abs(vals[i] - vals[i+1]) == Math.abs(result[0] - result[1])){
                    if(Math.abs(vals[i] + vals[i+1]) <= Math.abs(result[0] + result[1])){
                        continue;
                    }
                }
                result[0] = vals[i];
                result[1] = vals[i+1];
            }
        }
        return result;
    }
}
