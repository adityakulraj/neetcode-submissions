class MedianFinder {

    PriorityQueue<Integer> pqs = new PriorityQueue<>((a,b) -> (b - a));

    PriorityQueue<Integer> pql = new PriorityQueue<>();

    public MedianFinder() {

        
    }
    
    public void addNum(int num) {

        pqs.offer(num);

        if(pqs.size() > pql.size() + 1 || ! pql.isEmpty() && pqs.peek() > pql.peek())
         {
            int val = pqs.poll();
            pql.offer(val);
         }

         if(pql.size() > pqs.size() + 1) {
            pqs.offer(pql.poll());
         }
        


        
    }
    
    public double findMedian() {

        if(pqs.isEmpty() && pql.isEmpty())
         return 0.0;

        if(pqs.size() > pql.size()) {
            return pqs.peek();
        }

        else if(pqs.size() < pql.size())
           return pql.peek();

        else {
            return ((double) pqs.peek() + (double)pql.peek())/2.0;
        }   
 
    }
}
