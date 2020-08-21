import java.io.*;
import java.util.*;
import java.math.*;

public class P4V00872923 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //All input as one String
        String input = in.nextLine();
        
        //Obtain value of p (power)
        int p = Integer.valueOf(input.substring(2,3));
        //Obtain value of n 
        BigInteger x = new BigInteger(input.substring(4));
        
        //Decide do to perform a square or cube root depending on p
        if(p == 2){
            System.out.println(square_root(x));
        }else if( p == 3){
            System.out.println(cube_root(x));
        }else{
            System.out.println("Something went wrong my friend");
        }
        
        
    }
    /*
    *   Basic binary search help was referenced from https://www.geeksforgeeks.org/binary-search-in-java/
    *   BigInteger documentation and help referenced from https://www.geeksforgeeks.org/biginteger-class-in-java/
    */
    
    //Binary Search square root method
    static BigInteger square_root(BigInteger x){
        BigInteger start = new BigInteger("0");
        BigInteger end = new BigInteger(x.toString());
        BigInteger result = new BigInteger("0");
        BigInteger two = new BigInteger("2");
        
        while(start.compareTo(end)<=0){
            //Find middle 
            BigInteger middle = new BigInteger(start.add(end).divide(two).toString());
            //If middle * middle = x, middle is the square root
            if (middle.multiply(middle).compareTo(x) == 0) 
                return middle;
            //If middle * middle < x, binary search left half
            if (middle.multiply(middle).compareTo(x) < 0) 
            { 
                start = middle.add(BigInteger.ONE); 
                result = middle;
            }
            //If middle * middle > x, binary search right half
            else{
                end = middle;
            }
        }
        return result;
    }
    //Binary Search cube root method
    static BigInteger cube_root(BigInteger x){
        BigInteger start = new BigInteger("0");
        BigInteger end = new BigInteger(x.toString());
        BigInteger result = new BigInteger("0");
        BigInteger two = new BigInteger("2");
        
        while(start.compareTo(end)<=0){
            //Find middle 
            BigInteger middle = new BigInteger(start.add(end).divide(two).toString());
            //If middle * middle * middle = x, middle is the square root
            if (middle.multiply(middle).multiply(middle).compareTo(x) == 0) 
                return middle;
            //If middle * middle * middle < x, binary search left half
            if (middle.multiply(middle).multiply(middle).compareTo(x) < 0) 
            { 
                start = middle.add(BigInteger.ONE); 
                result = middle;
            }
            //If middle * middle * middle > x, binary search right half
            else{
                end = middle;
            }
        }
        return result;
    }
}