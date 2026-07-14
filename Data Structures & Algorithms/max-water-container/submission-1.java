class Solution {
    public int maxArea(int[] heights) {


        int n = heights.length;


        int l = 0;
        int r = n - 1;

        int max = 0;


        while(l<=r) {

            int vall = heights[l];
            int valr = heights[r];

            int curr = Math.min(vall, valr) * (r - l);

            max = Math.max(max,curr);

            if(vall <= valr) 
            l++;

            else 
            r--;



        }

        return max;
        
    }
}
