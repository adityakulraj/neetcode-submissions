class StockSpanner {

    

    class Pair {

        int idx;
        int val;

        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    int k;
    Stack<Pair> st;

    public StockSpanner() {

         k = 0;
         st = new Stack<>();
        
    }
    
    public int next(int price) {


        int pops = 0;
        ++k;

        while(!st.isEmpty() && price >= st.peek().val) {
              st.pop();
              pops++;
        }

    
        Pair top = null;
        boolean flag = st.isEmpty();
        if(!flag) {
          top = st.peek();
        }
        st.push(new Pair(k, price));

        

        if(pops==0) {
         return 1;
        }

        else {
            if(flag) {
                return k;
            }
            else
             {
               // System.out.println(top.val);
                return k - top.idx;
             }
        } 
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */