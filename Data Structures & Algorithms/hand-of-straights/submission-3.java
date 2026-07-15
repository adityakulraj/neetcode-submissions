class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {


        int [] count = new int[1001];

        int total = 0;


        for(int i : hand) {
            count[i]++;
            total++;
        }

        if(total % groupSize != 0 || total < groupSize)
        return false;



        for(int i=0;i<=1000;) {

            if(count[i] > 0 && (i==0 || count[i-1]==0)) {
               
                int start = i;

                int currcount = 0;
                

                while(count[start] > 0 && currcount < groupSize) {

                    count[start]--;

                    currcount++;  
                    start++;
                }

                System.out.println("currcount " +currcount + " i: " + i);

                Arrays.stream(count).forEach(element -> System.out.print(element+" "));
                System.out.println();

                if(currcount < groupSize)
                return false;



            }

            else {
                i++;
            }


        }



        return true;




       
    }
}
