class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
           map.put(i, map.getOrDefault(i,0)+1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for(int i : map.keySet()) {

            int l = i;
            int r = map.get(i);

            heap.offer(new int[]{r, l});

            if(heap.size() > k) {
                heap.poll();
            }

        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;

        
    }
}
