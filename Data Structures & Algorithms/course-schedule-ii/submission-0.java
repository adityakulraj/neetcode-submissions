class Solution {
    public int[] findOrder(int n, int[][] pre) {



        Map<Integer, List<Integer>> graph = new HashMap<>();

        int [] inDeg = new int[n];



        for(int i=0;i<n;i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int [] p : pre) {

            int l = p[0];
            int r = p[1];

            graph.get(r).add(l);

            inDeg[l]++;

        }

        for(int i=0;i<n;i++) {
            System.out.println(graph.get(i));
            System.out.println("inDeg :" + inDeg[i]);
        }


        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++) {
            if(inDeg[i]==0) {
            q.add(i);
            }
        }

        int [] ans = new int[n];
        int k = 0;

        System.out.println(q);


        while(!q.isEmpty()) {

            int src = q.poll();
            ans[k++] = src;

            System.out.println("src :" + src);

            for(int i : graph.get(src)) {
                inDeg[i]--;

                if(inDeg[i]==0)
                q.add(i);
            }
        }

        for(int i=0;i<n;i++) {
            if(inDeg[i]!=0)
             return new int[0];
        }

        return ans;


        
    }
}
