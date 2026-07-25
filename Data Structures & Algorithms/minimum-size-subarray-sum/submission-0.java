class Solution {
    public int minSubArrayLen(int target, int[] nums) {


        int l = 0;
        int r = 0;


        int currsum = 0;
        int minlen = Integer.MAX_VALUE;
        int n = nums.length;


        while(r<n) {

            currsum += nums[r];

            while(currsum >= target && l <= r) {

                minlen = Math.min(minlen, r - l + 1);

                System.out.println("L : "+ l +" R : "+ r +" minlen: "+ minlen);

                currsum -= nums[l];

                l++;

            }

            r++;
        }


        if(minlen == Integer.MAX_VALUE)
        return 0;

        
        return minlen;

        
        
    }
}