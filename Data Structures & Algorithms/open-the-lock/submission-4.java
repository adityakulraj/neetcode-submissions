class Solution {

     static class Move {

        String s;
        int mv;

        public Move(String s, int mv) {
            this.s = s;
            this.mv = mv;
        }
    }
    public static int openLock(String[] deadends, String target) {


        Set<String> dead = new HashSet<>(Arrays.asList(deadends));


        String start = "0000";

        if (dead.contains(start)) {
             return -1;
        }


        Queue<Move> q = new LinkedList<>();
        q.offer(new Move(start, 0));


        Set<String> visited = new HashSet<>();
        visited.add(start);

        while(!q.isEmpty()) {


            Move m = q.poll();

            String s = m.s;
            int mv = m.mv;
            visited.add(s);

            if(s.equals(target))
                return mv;


            char [] arr = s.toCharArray();

            for(int i=0;i<4;i++) {

                char tmp = arr[i];

                arr[i] = (char) ((tmp - '0' + 1)%10 + '0');

              //  System.out.println(new String(arr));

                if(!dead.contains(new String(arr)) && !visited.contains(new String(arr))) {
                    q.offer(new Move(new String(arr) , mv+1));
                    visited.add(new String(arr));
                   // System.out.println(new String(arr));
                }

                

                arr[i] = (char)((tmp - '0' - 1 + 10)%10 + '0');

                if(!dead.contains(new String(arr)) && !visited.contains(new String(arr))) {
                    q.offer(new Move(new String(arr) , mv+1));
                    visited.add(new String(arr));
                   // System.out.println(new String(arr));
                }

                arr[i] = tmp;


            }





        }

        return -1;






    }



    
    
}