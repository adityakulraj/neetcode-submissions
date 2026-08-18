class Solution {
    public int evalRPN(String[] tokens) {

        Stack<String> st = new Stack<>();


        for(String s : tokens) {

            if(isNumeric(s)) {
                st.add(s);
            }
            else {
                int b = Integer.parseInt(st.pop());
                int a = Integer.parseInt(st.pop());

                if(s.equals("+"))
                 {
                    st.push(String.valueOf(a + b));
                 }
                 else if(s.equals("-")) {
                    st.push(String.valueOf(a - b));
                 }
                 else if(s.equals("/")) {
                    st.push(String.valueOf(a/b));
                 }
                 else {
                    st.push(String.valueOf(a * b));
                 }
            }

        }

        return Integer.parseInt(st.pop());
        
    }

    public boolean isNumeric(String s) {

        try {

            int i = Integer.parseInt(s);

            return true;

        }

        catch(Exception e) {
            return false;
        }
    }
}
