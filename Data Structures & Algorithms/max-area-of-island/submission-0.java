class Solution {
    public int maxAreaOfIsland(int[][] grid) {


        int n = grid.length;

        int m = grid[0].length;

        boolean [][] visited = new boolean[n][m];

        int max = 0;


        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {

                if(grid[i][j]==1 && !visited[i][j])
                  {
                    max = Math.max(max, dfs(grid, n, m, i, j, visited));
                  }
            }
        }

        return max;
        
    }

    public int dfs(int [][] grid, int n, int m, int i, int j, boolean [][] visited) {


        


        if(i<0 || i >=n || j<0 || j>=m ||visited[i][j] || grid[i][j]==0)
        return 0;

        visited[i][j] = true;


        int ans = 1;

        ans += dfs(grid, n, m,i+1,j,visited);
        ans += dfs(grid, n, m,i-1,j,visited);
        ans += dfs(grid, n, m,i,j-1,visited);
        ans += dfs(grid, n, m,i,j+1,visited);

        return ans;

    }
}
