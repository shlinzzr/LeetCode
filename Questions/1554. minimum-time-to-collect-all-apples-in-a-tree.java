// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] seen = new boolean[n];
        for(int i=0; i<n; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int[]e :edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        
        return dfs(map, hasApple, 0, 0, seen);
        
    }
    
    
    private int dfs( Map<Integer, List<Integer>> map, List<Boolean> hasApple, int node, int cost, boolean[] seen){
        
        if(seen[node])
            return 0;
        seen[node]=true;
        
        
        List<Integer> list = map.get(node);
        
        int res = 0;
        
        for(int next : list){
            res += dfs(map, hasApple, next, 2, seen);
        }
        
        if(res==0 && hasApple.get(node) == false)
            return 0;
        
        
        
        return res+cost;
    }
}