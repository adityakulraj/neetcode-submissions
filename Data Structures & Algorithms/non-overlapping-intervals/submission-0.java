class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {


        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));


        int res = 0;
        int prevEnd = intervals[0][1];


        for(int i=1;i<intervals.length;i++) {

            int st = intervals[i][0];
            int en = intervals[i][1];

            if(st >= prevEnd) {
                prevEnd = en;
            }
            else {
                res++;
                prevEnd = Math.min(en, prevEnd);
            }
        }

        return res;
        
    }
}
