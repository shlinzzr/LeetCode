// https://leetcode.com/problems/time-needed-to-inform-all-employees

class Solution {
    
    int res = 0;
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        
        
        for(int i=0; i<n; i++){
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        
       // System.out.println(map.keySet()+ " " + map.values()); 
        
        return helper(-1, map, informTime,  0);
        
    }
    
    
    private int helper(int headID,  HashMap<Integer, List<Integer>> map, int[] informTime, int cur){
        
        
        if(!map.containsKey(headID)){
            return cur;
        }
        
        int max = 0;
        
        for(int m : map.get(headID)){
            
            helper(m, map, informTime, cur+informTime[m]);
            
            max = Math.max(max, informTime[m]);
        }
        
        return max + cur;
        
        
    }
    
    
}