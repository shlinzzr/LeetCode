// https://leetcode.com/problems/time-needed-to-inform-all-employees

class Solution {
    int sum=0;
    Map<Integer, List<Integer>> visited = new HashMap<>();
    
    
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
         if(n==1)
             return 0;
        
        for (int i = 0; i < manager.length; i++) {
            int j = manager[i];
            if (!visited.containsKey(j))
                visited.put(j, new ArrayList<>());
            visited.get(j).add(i);
        }
        
        
        int sum =inform(headID, manager, informTime);
                
        
        return sum;
        
    }
    
    private int inform(int id, int[] manager, int[] informTime){
        
        int n = manager.length;
        int max = 0;
        
        if (!visited.containsKey(id))
            return max;
        
        
        for (int i = 0; i < visited.get(id).size(); i++)
            max = Math.max(max, inform(visited.get(id).get(i), manager, informTime));
        
//         for(int i=0; i<n; i++){
            
//             if(manager[i]==id){
                
//                 max = Math.max(max, inform(i, manager, informTime));
//             }
//         }
        
        
        return max+informTime[id];
        
    }
    
    
    /*
    15
0
[-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6]
[1,1,1,1,1,1,1,0,0,0,0,0,0,0,0]
Output
*/
    
}