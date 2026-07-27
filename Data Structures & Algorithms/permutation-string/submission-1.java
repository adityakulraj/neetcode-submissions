class Solution {
    public boolean checkInclusion(String s1, String s2) {


        int [] counts1 = new int[26];
        int [] counts2 = new int[26];

        int ns1 = s1.length();
        int ns2 = s2.length();

        if(ns1 > ns2)
        return false;


        for(int i=0;i<ns1;i++) {

            counts1[s1.charAt(i) - 'a']++;
            counts2[s2.charAt(i) - 'a']++;

        }

        int match = 0;

        if(checkmatch(counts1, counts2))
         return true;


        for(int i=ns1;i<ns2;i++) {
            
            counts2[s2.charAt(i - ns1) - 'a']--;
            counts2[s2.charAt(i) - 'a']++;

            if(checkmatch(counts1, counts2))
             return true;
        }

        return checkmatch(counts1, counts2);


        
    }

    public boolean checkmatch(int [] counts1, int [] counts2) {

        int match = 0;

        for(int i=0;i<26;i++) {
            if(counts1[i]==counts2[i])
               match++;
        }

        return match==26;
    }


}
