class Solution {
    public int countSubstrings(String s) {


        int n = s.length();

        int [][] dp = new int[n][n];

        int count = 0;



        for(int i=0;i<n;i++) {
            dp[i][i] = 1;
            count++;
        }

        for(int i=0;i<n-1;i++) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1) ? 1 : 0;
            if(s.charAt(i)==s.charAt(i+1))
            count++;
        }


        for(int len=3;len<=n;len++) {
            for(int i=0;i<=n - len;i++) {

                int j = i + len - 1;

               // System.out.println("i : "+ i + " j : "+ j);



        
                 if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1] == 1)
                 {
                    dp[i][j] = 1;
                    count++;
                    //System.out.println("i : " +i+ " j: "+ j);
                 }

            }
        }

        return count;
        
    }
}
