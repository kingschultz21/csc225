import java.io.*;
import java.util.*;

public class Solution {
    
    /*This class is taken from geeksforgeeks.org*/
    static class FastReader {
        
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong() {
            return Long.parseLong(next());
        }
        
        double nextDouble() {
            return Double.parseDouble(next());
        }
        
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    
    static class FastPriorityQueue {
        private final TreeMap<Integer, Integer> tree
        = new TreeMap<>(Collections.reverseOrder());
        
        public void add(Integer x){//adds an element in O(log n)
            if(tree.containsKey(x)){
                tree.put(x, tree.get(x) + 1);
            }
            else{
                tree.put(x, 1);
            }
        }
        
        public void remove(Integer x){//removes any given element in O(log n)
            if(tree.containsKey(x)){
                Integer count = tree.get(x);
                if(count == 1){
                    tree.remove(x);
                }
                else{
                    tree.put(x, count - 1);
                }
            }
        }
        
        public Integer remove(){//removes and returns the maximum element
            Integer max = tree.firstKey();
            this.remove(max);
            return max;
        }
        
        public Integer peek(){//returns without removing the maximum element
            return tree.firstKey();
        }
        
        public boolean isEmpty(){
            return tree.isEmpty();
        }
    }
    
    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        FastReader in = new FastReader();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        FastPriorityQueue pq = new FastPriorityQueue();
        
        int n = in.nextInt();
        int k = in.nextInt();
        int[] numbers = new int[n];
        
        for(int i =0; i <n; i++){
            numbers[i] = in.nextInt();
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int index = 0;
        for(int j = 0; j < n; j++){
            pq.add(numbers[j]);
            if(pq.size()==k){
                int max1 = pq.poll();
                int max2 = pq.poll();
                out.write(Integer.toString(max1+max2)+" ");
                pq.clear();
                j = index;
                index++;
            }
        }
        
    
        out.flush();
        //print the output numbers using out.write()
        
        out.flush();
        
    }
}
