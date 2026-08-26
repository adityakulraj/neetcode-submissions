class Solution {
    public int trap(int[] height) {

        int n = height.length;

        int l = 0;
        int r = n - 1;

        int res = 0;
        int leftMax = height[l];
        int rightMax = height[r];

        while(l < r) {

            if(leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } 
            else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }

        
        }


        return res;
        
    }
}
