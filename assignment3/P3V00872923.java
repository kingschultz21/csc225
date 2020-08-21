import java.io.*;
import java.util.*;

public class P3V00872923 {
    
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
        public void clear(){
            tree.clear();
        }
    }
    
    public static void main(String[] args) throws Exception{
        //Fast I/O setup
        FastReader in = new FastReader();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        FastPriorityQueue pq = new FastPriorityQueue();
        
        //Store n, k and an array of the input numbers from STDIN
        int n = in.nextInt();
        int k = in.nextInt();
        int[] numbers = new int[n];
        for(int x = 0; x < n; x++){
            numbers[x] = in.nextInt();
        }
        
        //Add first k numbers
        for(int i = 0; i < k; i++){
            pq.add(numbers[i]);
        }
        int curr = k;
        
        //Solution Algortithm that removes the two max elements from every k
        //subset of n and prints the sum
        for(int j = 0; j < n-k+1; j++){
            int max1 = pq.remove();
            int max2 = pq.remove();
            int sum = max1 +max2;
            out.write(Integer.toString(max1+max2)+" ");
            pq.add(max1);
            pq.add(max2);
            pq.remove(numbers[j]);
            if(curr == n){
                break;
            }
            pq.add(numbers[curr]);
            curr++;
        }
        out.flush();
    }
}
