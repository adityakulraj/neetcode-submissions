class Solution {
    public int islandPerimeter(int[][] grid) {


        int n = grid.length;

        int m = grid[0].length;


        boolean [][] visited = new boolean[n][m];

        int peri = 0;


        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!visited[i][j] && grid[i][j]==1) {
                   peri += dfs(grid, i,j, n, m, visited);
                }
            }
        }

        return peri;
        
    }

    public int dfs(int [][] grid, int i,int j, int n, int m, boolean [][] visited) {


        if(i<0 || i >=n || j<0 || j>=m || grid[i][j] == 0)
        return 1;

        if(visited[i][j])
        return 0;

       

        visited[i][j] = true;

      

        

        


        int peri = 0;

        
        peri += dfs(grid, i+1, j, n,m, visited);
       
        peri += dfs(grid, i-1, j, n,m, visited);
  
        peri += dfs(grid, i, j+1, n,m, visited);
      
        peri += dfs(grid, i, j-1, n,m, visited);


        return peri;

    }
}