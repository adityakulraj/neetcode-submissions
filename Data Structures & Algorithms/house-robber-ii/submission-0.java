class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        int [] dp = new int[n];

        if(n==1)
         return nums[0];


        Arrays.fill(dp, -1);

        int one = dfs(nums,dp, 0, n-2);

        Arrays.fill(dp, -1);

        int two = dfs(nums, dp, 1, n-1);



        return  Math.max(one, two);      
    }

    public int dfs(int [] nums,int [] dp, int idx, int n) {

        if(idx>=n+1) {
            return 0;
        }

        if(dp[idx] != -1)
        return dp[idx];


        int take = dfs(nums,dp,idx+2, n) + nums[idx];

        int dontake = dfs(nums,dp, idx+1,n);

        dp[idx] = Math.max(take, dontake);

        return dp[idx];


    }
}
