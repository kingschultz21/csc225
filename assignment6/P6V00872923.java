import java.io.*;
import java.util.*;

public class P6V00872923 {
    public static void main(String[] args) {
        //setup
        FastReader input = new FastReader();
        int n  = input.nextInt();
        
        TreeSet<Integer> bst_A= new TreeSet<>();
        TreeSet<Integer> bst_B = new TreeSet<>();
        
        long result = 1;
        
        for(int i=0; i< n; i++){
            int val = input.nextInt();
            //First Number
            if(bst_A.isEmpty()){
                bst_A.add(val);
            //Keep trees Balanced
            }else if(bst_B.isEmpty() || bst_A.size() > bst_B.size()){
                if(val < bst_A.last()){
                    bst_B.add(bst_A.last());
                    bst_A.pollLast();
                    bst_A.add(val);
                }else{
                    bst_B.add(val);
                }
            }else if(bst_B.size() == bst_A.size()){
                if(val < bst_B.first()){
                    bst_A.add(val);
                }else if(val > bst_B.first()){
                    bst_A.add(bst_B.first());
                    bst_B.pollFirst();
                    bst_B.add(val);
                }
            }
            //modulo result to store in float
            result = ((result * bst_A.last())%1000000007);
        }
        System.out.println(result);
    }
}
//FastReader class referenced from Geeks for Geeks
//source: https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
 }
