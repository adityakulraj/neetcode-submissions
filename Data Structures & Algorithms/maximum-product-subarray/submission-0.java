class Solution {
    public int maxProduct(int[] nums) {

        int res = nums[0];

        int currMin = 1;
        int currMax = 1;

        for(int num : nums) {

            int tmp1 = currMax * num;
            int tmp2 = currMin * num;

            currMax = Math.max(Math.max(tmp1, tmp2), num);
            currMin = Math.min(Math.min(tmp1, tmp2), num);

            res = Math.max(res, currMax);

        }

        return res;
        
    }
}
