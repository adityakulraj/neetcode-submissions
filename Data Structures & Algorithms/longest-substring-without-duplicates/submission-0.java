class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s==null || s.isEmpty())
        return 0;


        HashMap<Character, Integer> map = new HashMap<>();

        int n = s.length();


        int l = 0;
        int r = 1;
        map.put(s.charAt(0), 0);
        int maxlen = 1;
        int currlen = 1;

        while(r<n) {

            char curr = s.charAt(r);

            if(map.containsKey(curr)&&map.get(curr)>=l&&map.get(curr)<=r) {

                maxlen = Math.max(currlen, maxlen);
                l = map.get(curr)+1;
                currlen = r - l + 1;

            } 

            else {
                currlen++;
            }

            map.put(curr, r);

            r++;
            



        }

        maxlen = Math.max(currlen, maxlen);
        return maxlen;
        
    }
}

