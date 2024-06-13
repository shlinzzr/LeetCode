// https://leetcode.com/problems/time-needed-to-inform-all-employees

class Solution {
    int sum=0;
    Map<Integer, List<Integer>> map = new HashMap<>(); //  manager, List<subordinates>
    
    
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
         if(n==1)
             return 0;
        
        for (int i = 0; i < manager.length; i++) {
            int m = manager[i];
            map.putIfAbsent(m , new ArrayList<>());
            map.get(m).add(i);
        }
        
        int sum = inform(headID, manager, informTime);
                
        
        return sum;
        
    }
    
    private int inform(int id, int[] manager, int[] informTime){
        
        int len = manager.length;
        int max = 0;

        //informTime[i] == 0 if employee i has no subordinates.
        if (!map.containsKey(id))
            return max;
        
        for (int i = 0; i < map.get(id).size(); i++)
            max = Math.max(max, inform(map.get(id).get(i), manager, informTime));
        
        return max+informTime[id];
        
    }
    
    
}