// https://leetcode.com/problems/time-needed-to-inform-all-employees

class Solution {
    
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        
        
        for(int i=0; i<n; i++){
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        
        return helper(headID, map, informTime);
        
    }
    
    
    private int helper(int id,  HashMap<Integer, List<Integer>> map, int[] informTime){
        
        if(!map.containsKey(id)){
            return 0;
        }
        
        int max = 0;
        
        for(int m : map.get(id)){
            
            int res  = helper(m, map, informTime);
            
            max = Math.max(max, res);
        }
        
        return max + informTime[id];
        
        
    }
    
    
}