class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;


        if(n==1)
        return nums[0];

        if(n==2)
        return nums[0] <= nums[1] ? nums[0] : nums[1];


        int l = 0;
        int r = n - 1;

        while(l < r) {

            int mid = l + (r-l)/2;

            if(nums[mid] < nums[r]) {
                r = mid;
            }
            else {
                l = mid + 1;
            }

        }

        return nums[l];
        
    }
}
