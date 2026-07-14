class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();


        int i = 0;
        int j = s.length()-1;

        while(i<=j) {

            boolean validi = (s.charAt(i)>='A' && s.charAt(i)<='Z') ||
               (s.charAt(i)<='z' && s.charAt(i) >= 'a') ||
               (s.charAt(i) <='9' && s.charAt(i) >= '0' );

            boolean validj =  (s.charAt(j)>='A' && s.charAt(j)<='Z') ||
               (s.charAt(j)<='z' && s.charAt(j) >= 'a') ||
               (s.charAt(j) <='9' && s.charAt(j) >= '0' );  


            if(!validi) {
                i++;  
                continue;
            }

            if(!validj) {
                j--;
                continue;
            }  


            if(s.charAt(i)!=s.charAt(j)) {
                return false;
            }

            i++;
            j--;



       

        }

        return true;
        
    }
}
