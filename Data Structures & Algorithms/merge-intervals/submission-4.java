class Solution {

     public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return intervals;

        // Use Integer.compare to prevent integer overflow
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Use LinkedList to access the last element easily
        LinkedList<int[]> merged = new LinkedList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < n; i++) {
            int[] lastMerged = merged.getLast(); // Look at the most recent interval
            int[] current = intervals[i];

            // Overlap condition
            if (lastMerged[1] >= current[0]) {
                // Since it's sorted, start time doesn't change. Just update end time.
                lastMerged[1] = Math.max(lastMerged[1], current[1]);
            } else {
                // No overlap, safely add the new interval
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
   
}
