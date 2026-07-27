class Solution {
    public int numSquares(int n) {




        int [] dp = new int[n+1];

       // Arrays.fill(dp,Integer.MAX_VALUE);

        if(n <= 4) {
            if(n==0)
             return 0;

            if(n==1 || n==2 || n==3)
              return n;

            return 1;   
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 1;

        


        for(int i=1;i*i<=n;i++) {
            dp[i*i] = 1;
        }

        for(int i=5;i<=n;i++) {
            
            int min = i;
            if(dp[i]==1)
             continue;
            for(int j=1;j<i;j++) {

                min = Math.min(min, dp[j] + dp[i-j]);

            }

            dp[i] = min;
            System.out.println(i+" " + dp[i]);
        }

        return dp[n];



        
    }
}