import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        /*
        *   Obtain input variables (int)
        */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for(int i = 0; i < n; i++){
            A[i] = input.nextInt();
        }
        for(int j = 0; j < n; j++){
            B[j] = input.nextInt();
        }
        
        /*
        *   Call Function and print result
        */
        String s = weirdEquality(A,B);
        System.out.println(s);
    }
    /*
    *   Recursive method that determines if two arrays
    *   have a "weird equality" as described by the assignment guidelines
    *   Parameters: int[], int[]
    *   Returns: String
    */
    public static String weirdEquality(int[] A, int[] B){
        /*
        *   Base Case
        */
        if(Arrays.equals(A,B)){
            return "YES";
        }
        else if(A.length % 2 != 0){
            return "NO";
        }else{
            //Split arrays
            int mid = A.length / 2;
            int[] A1 = Arrays.copyOfRange(A,0,mid);
            int[] A2 = Arrays.copyOfRange(A,mid,A.length);
            int[] B1 = Arrays.copyOfRange(B,0,mid);
            int[] B2 = Arrays.copyOfRange(B,mid,B.length);
            
            //Recursive calls
            if(weirdEquality(A1,B1).equals("YES") && weirdEquality(A2,B2).equals("YES")){
                return "YES";
            }
            else if(weirdEquality(A1,B1).equals("YES") && weirdEquality(A1,B2).equals("YES")){
                return "YES";
            }
            else if(weirdEquality(A2,B2).equals("YES") && weirdEquality(A2,B1).equals("YES")){
                return "YES";
            }else{
                return "NO";
            }
        }
            
    }
}
