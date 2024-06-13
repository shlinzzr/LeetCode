// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
                
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int[]e :edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        
        boolean[] seen = new boolean[n];
        
        return dfs(map, hasApple, seen, 0, 0);
        
    }
    
    private int dfs(Map<Integer, List<Integer>> map, List<Boolean> hasApple, boolean[] seen, int node, int cost){
        
        if(seen[node])
            return 0;
        seen[node]=true;
        
        int res = 0; 
        for(int next : map.get(node)){
            res+=dfs(map, hasApple, seen, next, 2);
        }
        
        if(res==0 && hasApple.get(node))
            return 0;
        
        return res+cost;
        
        
    }
}