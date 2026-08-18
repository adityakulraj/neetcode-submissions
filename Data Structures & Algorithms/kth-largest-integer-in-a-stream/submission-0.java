class KthLargest {

    int k;
    int [] nums;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        pq = new PriorityQueue<>();

        for(int i : nums) {
            pq.add(i);

            if(pq.size() > k)
             pq.poll();
        }
        
    }
    
    public int add(int val) {

        pq.add(val);

        if(pq.size() > k)
         pq.poll();

        return pq.peek(); 
        
    }
}
