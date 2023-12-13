package Graph;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int row,col,step;
    Node(int row , int col , int step){
        this.row=row;
        this.col=col;
        this.step=step;
    }
}

class Matrix01{
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<Node> q=new LinkedList<>();
        int[][] vis=new int[m][n];
        int[][] distance = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new Node(i,j,0));
                    vis[i][j]=1;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int delrow[] = {-1, 0, +1, 0}; 
	    int delcol[] = {0, +1, 0, -1}; 
        while(!q.isEmpty()){
            int row = q.peek().row; 
	        int col = q.peek().col; 
	        int steps = q.peek().step; 
	        q.remove(); 
	        distance[row][col] = steps; 
	        for(int i = 0;i<4;i++) {
	            int nrow = row + delrow[i]; 
	            int ncol = col + delcol[i]; 
	            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0) {
	                vis[nrow][ncol] = 1; 
    	            q.add(new Node(nrow, ncol, steps+1));  
	            } 
	        }
        }
        return distance;
    }
}
/*
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //Custom Pair class for storing cell to Queue
        class Pair{
            int row;
            int col;
            Pair(int row, int col){
                this.row = row;
                this.col = col;
            }
        }
        
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int ans[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    queue.offer(new Pair(i, j)); // Storing cell which contains zero
                    ans[i][j] = 0;
                }
                else{
                    ans[i][j] = -1;
                }
            }
        }
        
        //Applying BFS
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            int row = temp.row;
            int col = temp.col;
            
            //If diagnal cell is valid and not visited yet then update it's distance from zero
            if(isValid(row, col+1, n, m) && ans[row][col+1] == -1){
                queue.offer(new Pair(row, col+1));
                ans[row][col+1] = ans[row][col] + 1;
            }
            
            if(isValid(row, col-1, n, m) && ans[row][col-1] == -1){
                queue.offer(new Pair(row, col-1));
                ans[row][col-1] = ans[row][col] + 1;
            }
            
            if(isValid(row+1, col, n, m) && ans[row+1][col] == -1){
                queue.offer(new Pair(row+1, col));
                ans[row+1][col] = ans[row][col] + 1;
            }
            
            if(isValid(row-1, col, n, m) && ans[row-1][col] == -1){
                queue.offer(new Pair(row-1, col));
                ans[row-1][col] = ans[row][col] + 1;
            }
        }
        return ans;
    }
    
    //Method for checing validity
    public boolean isValid(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }
        return true;
    }
}
 */