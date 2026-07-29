class Solution {
    public int findJudge(int n, int[][] trust) {

        List<Integer> [] adj = new List[n+1];

        for(int i=0;i<=n;i++) {
            adj[i] = new ArrayList<>();
        }


        for(int [] t : trust) {
            adj[t[0]].add(t[1]);
        }


        for(int i = 1;i<=n;i++) {

            List<Integer> l = adj[i];

            if(l.size()==0) {
                if(checkOthers(i, adj, n))
                  return i;
            }
        }


        return -1;
        
    }

    public boolean checkOthers(int idx, List<Integer> [] adj, int n) {

      

        for(int i=1;i<=n;i++) {
            if(i==idx)
            continue;

            List<Integer> l = adj[i];

            if(!l.contains(idx))
             return false;

        }

        return true;
    }
}