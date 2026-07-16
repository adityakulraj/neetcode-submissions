class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> sortedIntervals = new ArrayList<>(intervals.length + 1);

    for (int[] interval : intervals) {
        sortedIntervals.add(new int[]{interval[0], interval[1]});
    }

    sortedIntervals.add(new int[]{newInterval[0], newInterval[1]});


    sortedIntervals.sort((a, b) -> Integer.compare(a[0], b[0]));

    List<int[]> merged = new ArrayList<>();

    for (int[] current : sortedIntervals) {
        if (merged.isEmpty()
                || current[0] > merged.get(merged.size() - 1)[1]) {
            // No overlap.
            merged.add(new int[]{current[0], current[1]});
        } else {
            // Merge with the last interval.
            int[] previous = merged.get(merged.size() - 1);
            previous[1] = Math.max(previous[1], current[1]);
        }
    }

    return merged.toArray(new int[merged.size()][]);
}
  
}
