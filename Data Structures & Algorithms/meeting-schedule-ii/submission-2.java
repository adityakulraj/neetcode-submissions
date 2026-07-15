/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        Collections.sort(intervals, (a,b) -> a.start - b.start);

        if(intervals.size()==0)
        return 0;


        PriorityQueue<Integer> pq = new PriorityQueue<>();


        pq.add(intervals.get(0).end);

        int maxrooms = 1;


        for(int i = 1; i < intervals.size(); i++) {

            int currs = intervals.get(i).start;

            if(currs < pq.peek()) {

                pq.add(intervals.get(i).end);

               
                maxrooms = Math.max(maxrooms, pq.size());

            }

            else {
                pq.poll();

                pq.add(intervals.get(i).end);


                
            }

            
        }

        return maxrooms;


        


        

        

        



       

    }
}
