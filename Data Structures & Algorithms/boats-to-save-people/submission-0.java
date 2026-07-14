class Solution {
    public int numRescueBoats(int[] people, int limit) {


        Arrays.sort(people);

        int n = people.length;


        int i = 0;
        int j = n -1;

        int count = 0;


        while(i<=j) {

        if(i==j) {
            count++;
            break;
        }    
        int val = people[i] + people[j];

        if(val <= limit) {
            i++;
            j--;
            count++;
        }

        else {
            j--;
            count++;
        }
        }

        return count;
        
    }
}