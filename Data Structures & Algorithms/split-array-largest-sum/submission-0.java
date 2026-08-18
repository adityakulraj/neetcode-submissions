class Solution {
    public int splitArray(int[] nums, int k) {

        int n = nums.length;

        int l = 0;
        int r = 0;


        for(int i=0;i<n;i++) {
              r += nums[i];
              l = Math.max(l, nums[i]);

        }

        System.out.println(l+" "+r);

        int ans = l;



        while(l<=r) {
            int mid = (r + l)/ 2;

            if(canDivide(nums,k, mid)) {
                ans = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return ans;
        
    }

    public boolean canDivide(int [] nums, int k, int mid) {

        int currSum = 0;
        int parts = 0;

        for(int i=0;i<=nums.length;i++) {

          if(i==nums.length) {
            if(currSum > 0)
              {
                parts++;
                break;
              }
          }  
          currSum += nums[i];

          if(currSum > mid)
          {
            parts++;
            currSum = nums[i];
          }
        }

        

        System.out.println("mid :" + mid +" k : "+ k + " parts: "+ parts);

        return parts <= k;
    }
}