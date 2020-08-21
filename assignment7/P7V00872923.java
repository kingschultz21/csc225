import java.io.*;
import java.util.*;

/*
*   References:
    GeeksforGeeks "distance between two cells in a matrix"
    https://www.geeksforgeeks.org/
    
    Mostly used to help with some bug finding in BFS
    and usage of the 'visited' matrix
*
*/
public class P7V00872923{
    //Node class that all the cells of the grid will
    //be stored in
    static class Node{
        int x;
        int y;
        int d;
        Node(int x, int y,int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        //Weird starting value for some reason? 
        //Just ignore it and be a good boy
        String garb = input.nextLine();
        
        //nxn matrix of all the dataz
        char[][] matrix = new char[n][n];
        //Store start and finish x & y positions
        Node start = new Node(-1,-1,0);
        Node finish = new Node(-1,-1,0);
        
        boolean[][] visited = new boolean[n][n];
        //Store data
        for(int i = 0; i < n; i++){
            String row = input.nextLine();
            for(int j = 0; j < row.length(); j++){
                matrix[i][j] = row.charAt(j);
                //Mark all regions as visited initially
                visited[i][j] = false;
                if(matrix[i][j] == 'A'){
                    start.x = i;
                    start.y = j;
                }else if(matrix[i][j] == 'B'){
                    finish.x = i;
                    finish.y = j;
                //If cell is an invalid space, simply mark as visited
                //to avoid being used by the BFS algorithim
                }else if(matrix[i][j] == '#'){
                    visited[i][j] = true;
                }
            }
        }
        /*
            BFS ALGORITHIM
        */
        Queue<Node> q = new LinkedList<Node>();
        q.add(start);
        visited[start.x][start.y] = true;
        int result = -1;
        while(!q.isEmpty()){
            //Current node being evaluated
            Node curr = q.remove();
            //The end has been found, the journey is over 
            if (matrix[curr.x][curr.y] == 'B') 
                result = curr.d;
            //MOVE LEFT
            if (curr.y - 1 >= 0 && visited[curr.x][curr.y - 1] == false) { 
                Node temp = new Node(curr.x, curr.y - 1, curr.d + 1);
                q.add(temp); 
                visited[curr.x][curr.y - 1] = true; 
            } 
            //MOVE RIGHT 
            if (curr.y + 1 < n && visited[curr.x][curr.y + 1] == false) { 
                Node temp = new Node(curr.x, curr.y + 1, curr.d + 1);
                q.add(temp); 
                visited[curr.x][curr.y + 1] = true; 
            } 
            //MOVE UP 
            if (curr.x - 1 >= 0 && visited[curr.x - 1][curr.y] == false) { 
                Node temp = new Node(curr.x - 1, curr.y, curr.d + 1);
                q.add(temp); 
                visited[curr.x - 1][curr.y] = true; 
            } 
            //MOVE DOWN
            if (curr.x + 1 < n && visited[curr.x + 1][curr.y] == false) { 
                Node temp = new Node(curr.x + 1, curr.y, curr.d + 1);
                q.add(temp); 
                visited[curr.x + 1][curr.y] = true; 
            }
        }
        //Print the result
        if(result == -1)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(result);
    }
        
        
        
}
