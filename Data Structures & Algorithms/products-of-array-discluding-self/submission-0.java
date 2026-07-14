class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int [] lprefix = new int[n];

        int [] rprefix = new int[n];

        if(n==1)
        return nums;

        lprefix[0] = nums[0];

        rprefix[n-1] = nums[n-1];

        for(int i=1;i<n;i++) {

            lprefix[i] = lprefix[i-1] * nums[i];

        }

        for(int i=n-2;i>=0;i--) {

            rprefix[i] = rprefix[i+1] * nums[i];

        }


        int [] ans = new int[n];

        for(int i=1;i<n-1;i++) {
            ans[i] = lprefix[i-1] * rprefix[i+1];
        }

        ans[0] = rprefix[1];
        ans[n-1] = lprefix[n-2];

        return ans;


        
    }
}  
