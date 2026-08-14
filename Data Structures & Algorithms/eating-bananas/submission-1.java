class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int minSpeed = 1;
        
        int maxSpeed = 1;
        int ans = 0;

        for(int i : piles) {
            maxSpeed = Math.max(maxSpeed, i);
            ans += i;
        }


        int l = minSpeed;
        int r = maxSpeed;

        while(l<=r) {
            int mid = (l+r)/2;

            if(checkifpossible(piles,mid,h)) {

                ans = mid;
                r = mid - 1;
            }
            else {
                 l = mid + 1;
            }
        }

        return ans; 
        
    }

    public boolean checkifpossible(int [] piles, int mid, int h) {

        int time = 0;

        for(int i : piles) {

            //System.out.print(Math.ceil((double)i/mid) +"  ");

            time += Math.ceil((double)i/mid);
        }

        //System.out.println("time :" + time +" mid: "+ mid);

        if(time <= h)
        return true;

        return false;
    }
}
