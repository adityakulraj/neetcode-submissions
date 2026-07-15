class Solution {
    public int[] dailyTemperatures(int[] temp) {

        int n = temp.length;

        Stack<Integer> st = new Stack<>();

        st.push(n-1);

        int [] ans = new int[n];

        ans[n-1] = 0;

        for(int i = n-2; i >= 0; i-- ) {


            int val = temp[i];

            if(val >= temp[st.peek()]) {


                while(!st.isEmpty() && val >= temp[st.peek()]) {
                    st.pop();
                }

                if(st.isEmpty())
                ans[i] = 0;

                else
                ans[i] = st.peek() - i;

                st.push(i);


            }

            else {

                ans[i] = st.peek() - i;

                st.push(i);

                
                


            }

            st.stream()
             .forEach(element -> System.out.print(element + " ")); 

             System.out.println();
        }

        return ans;


        


        
    }
}
