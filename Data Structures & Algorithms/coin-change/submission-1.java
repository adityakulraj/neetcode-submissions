class Solution {


    Map<Integer,Long> memo = new HashMap<>();

    long ans = Integer.MAX_VALUE;
    
    public int coinChange(int[] coins, int amount) {

        //Arrays.sort(coins);


        ans = dfs(coins, amount);

        if(ans >= Integer.MAX_VALUE)
        return -1;

        else return (int)(ans);


        
    }

    public long dfs(int [] coins, int amount) {

        if(amount == 0)
        return 0;

        if(amount < 0)
        return Integer.MAX_VALUE;


        long res = Integer.MAX_VALUE;

        if(memo.containsKey(amount))
         return memo.get(amount);


        for(int i=0;i<coins.length;i++) {
            long curr = Integer.MAX_VALUE;
            if(amount - coins[i] >= 0) {
               curr = 1 + dfs(coins, amount - coins[i]);
               if(curr < Integer.MAX_VALUE) {
               res = Math.min(res, curr);
            
               }
            }
        }

           memo.put(amount, res);

        return res;

    }
}
