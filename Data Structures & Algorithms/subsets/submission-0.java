class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        int n = nums.length;

        
        backtrack(nums, 0, n, new ArrayList<>());

        return ans;
        
    }

    public void backtrack(int [] nums, int idx, int n, List<Integer> list)    {

        if(idx == n){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        backtrack(nums,idx+1, n, list);
        list.remove(list.size() - 1);
        backtrack(nums, idx+1, n, list);


    } 
}
