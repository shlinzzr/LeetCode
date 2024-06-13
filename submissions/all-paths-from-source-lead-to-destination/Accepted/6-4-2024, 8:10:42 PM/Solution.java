// https://leetcode.com/problems/all-paths-from-source-lead-to-destination

class Solution {
    
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] e: edges){
            map.putIfAbsent(e[0], new HashSet<>());
            map.get(e[0]).add(e[1]);
        }
        
        if(map.containsKey(destination)) return false;
        
        // int out = map.getOrDefault(source, new HashSet()).size();
        // if(out==0) return false;
        
        
        return helper(map, source, destination, new HashMap<>());
        
        

        
    }
    
    
    private boolean helper( Map<Integer, Set<Integer>> map , int curr, int dest, Map<Integer, Boolean> memo){
        
        if(memo.containsKey(curr)) 
            return memo.get(curr);
        
        if(curr==dest){
            return true;
        }
        
        if(!map.containsKey(curr)) {
            memo.put(curr, false);
            return false;
        }
        
        memo.put(curr, false); //這裡先給值, 避免了無窮回圈
        for(int next:  map.get(curr)){
            boolean res = helper(map, next, dest, memo);
            if(res==false)
                return false;
        }
        
        memo.put(curr, true);
        return true;
    }
}