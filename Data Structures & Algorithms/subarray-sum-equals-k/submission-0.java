class Solution {
    public int subarraySum(int[] nums, int k) {


        Map<Integer, Integer> map = new HashMap<>();



        map.put(0, 1);



        int currsum = 0;

        int ans = 0;



        for(int i : nums) {

         currsum += i;


         if(map.containsKey(currsum - k) ) {
            ans += map.get(currsum - k);
         }

          map.put(currsum, map.getOrDefault(currsum,0)+1);
        }

        return ans;



        
    }
}