class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {


        int n = s.length();


        Set<String> set = new HashSet<>();

        set.addAll(wordDict);

        boolean [] dp = new boolean[n+1];

        dp[0] = true;


        for(int end=1;end<=n;end++) {
            for(int start= 0;start<end;start++) {
                if(!dp[start])
                continue;

                if(set.contains(s.substring(start,end))) {
                    dp[end] = true;
                    System.out.println("here");
                    break;
                }
            }
        } 

        return dp[n];
        
    }
}
