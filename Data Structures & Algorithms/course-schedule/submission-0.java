class Solution {

    private Map<Integer, List<Integer>> preMap = new HashMap<>();


    


    public boolean canFinish(int n, int[][] pr) {



        for(int i=0;i<n;i++) {
            preMap.put(i, new ArrayList<>());
        }

        for(int [] pre : pr) {
            List<Integer> ll = preMap.get(pre[0]);

            ll.add(pre[1]);
        }


        for(int i=0;i<n;i++) {

            Set<Integer> visited = new HashSet<>();

            if(!dfs(preMap, visited, i))
               return false;



        }

        return true;


        
    }

    public boolean dfs(Map<Integer, List<Integer>> mp, Set<Integer> visited, int i) {

        if(visited.contains(i))
        return false;


        visited.add(i);

        

        for(int j : mp.get(i)) {

             if(!dfs(mp, visited, j))
              return false;

        }

        visited.remove(i);

      //  preMap.put(i, new ArrayList<>());

        return true;

        


    }
}
