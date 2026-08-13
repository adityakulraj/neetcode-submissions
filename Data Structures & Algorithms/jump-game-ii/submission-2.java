class Solution {
    public int jump(int[] nums) {


        int n = nums.length; 


        int [] memo = new int[n];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;


        for(int i=1;i<n;i++) {

            for(int j=0;j<i;j++) {
                if(nums[j] + j >= i) {
                    memo[i] = Math.min(memo[i], memo[j] + 1);
                }
            }
        }

        return memo[n-1];

        
        
    }
}
