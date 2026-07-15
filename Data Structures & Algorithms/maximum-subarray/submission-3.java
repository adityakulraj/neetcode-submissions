class Solution {
    public int maxSubArray(int[] nums) {


        int n = nums.length;

        if(n==1)
        return nums[0];

        int currsum = 0;
        int maxsum = nums[0];
       // int maxsofar = Integer.MIN_VALUE;


        for(int i=0;i<n;i++) {

             if(currsum < 0)
             currsum = 0;

            currsum += nums[i];
            maxsum = Math.max(maxsum, currsum);


        }

        return maxsum;
        
    }
}
