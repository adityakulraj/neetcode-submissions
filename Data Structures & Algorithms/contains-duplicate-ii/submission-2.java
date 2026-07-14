class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {



        

        int l = 0; int r = 1;

        int n = nums.length;

        

        Set<Integer> set = new HashSet<>();

        set.add(nums[0]);


        while(r<n && l<r) {
        


           if(set.contains(nums[r]))
              return true;

          
           set.add(nums[r]);
           r++;

           if( r - l > k) {
            set.remove(nums[l]);
            l++;
           }   
        }

        return false;

        
    }
}