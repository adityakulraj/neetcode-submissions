class Solution {

    class T {
        int r;
        int c;
        int min;

        public T(int r,int c, int min) {
            this.r = r;
            this.c = c;
            this.min = min;
        }
    }
    public int orangesRotting(int[][] grid) {


        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;

        Queue<T> q = new LinkedList<>();


        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==2) {
                    q.add(new T(i,j,0));
                }

                else if(grid[i][j]==1)
                   fresh++;
            }
        }

        int [][] dir = new int[][]{{0, 1} ,{0, -1} , {1, 0}, {-1,0}};

        int ans = 0;

        //System.out.println(q);

        boolean [][] visited = new boolean[n][m];

        while(!q.isEmpty()) {

            T t = q.poll();

            int r = t.r;
            int c = t.c;
            int min = t.min;
            visited[r][c] = true;

            printGrid(grid);
            System.out.println();

            


            for(int [] d : dir) {


                int rx = r + d[0];
                int cx = c + d[1];

                if(rx >=0 && rx < n && cx >= 0 && cx < m && grid[rx][cx]==1 && !visited[rx][cx]) {
                    grid[rx][cx] = 2;
                    fresh--;
                    q.add(new T(rx, cx, min+1));
                    ans = Math.max(ans, min+1);
                    //System.out.println(ans+" ");
                }
                  
            }

           


        }

         return fresh==0? ans : -1;







        
    }

    public void printGrid(int [][] grid) {

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                System.out.print(grid[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
