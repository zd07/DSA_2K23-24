class Solution {

    public int[][]
    
    onesMinusZeros(int[][] grid) {
    
    int m grid.length;
    
    int n = grid [0].length;
    
    int[][] result = new int [m][n];
    
    int[] rowOne = new int[m];
    
    int[] rowZero = new int[m];
    
    int[] colone = new int [n];
    
    int[] colZero = new int [n];
    
    for(int i = 0; i < m; i++){
    
    int CountRowZero = 0;
    
    int CountRowOne = 0;
    
    for(int j = 0; j < n; j++)
    
    if(grid[i][j]==0) { CountRowZero++;
    
    }
    
    else{ CountRowOne++;
    
    }
    
    {
    
    }
    
    rowOne[i] = CountRowOne;
    
    rowZero[i] = CountRowZero;
    
    }
    
    for(int i = 0; i < n; i++){
    
    int CountCol0ne = 0;
    
    int CountColZero = 0;
    
    for(int j = 0; j< m; j++) {
    
    if(grid[j][i] == 0) {
    
    CountColZero++;
    
    }
    
    else{ CountColOne++;
    
    }
    
    }
    
    colone[i] = Count Col0ne;
    
    colZero[i] = CountColZero;
    
    }
    
    for(int i=0; i < m; i++){
    
    for(int j = 0; j < n; j++)
    
    { result[i][j] = rowOne[i]+colone[j]-rowZero[i]- colone[j]; } }
    
    return result;
    
    }

}
