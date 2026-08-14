class Solution {
    public int countComponents(int n, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();


        for(int i=0;i<n;i++) {
            map.put(i, new ArrayList<>());
        }


        for(int [] e : edges) {

            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        Set<Integer> set = new HashSet<>();

        int count = 0;


        for(int i=0;i<n;i++) {

            if(!set.contains(i)) {
                dfs(i, map, set,n);
                count++;

            }
        }

        return count;

    }

    public void dfs(int i, Map<Integer, List<Integer>> adj, Set<Integer> set, int n) {


        if(i>=n || i<0 || set.contains(i))
        return;

        set.add(i);

        for(int j : adj.get(i)) {

            if(!set.contains(j)) {
                dfs(j, adj, set,n);
            }
        }
    }
}
