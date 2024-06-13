// https://leetcode.com/problems/time-needed-to-inform-all-employees

class Solution {
    int sum=0;
    HashSet<Integer> visited = new HashSet<>();
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
         if(n==1)
             return 0;
    
        
        for(int i=0; i<n; i++){
            
            if(!visited.contains(manager[i])){
                int id = manager[i];
                inform(id, manager, informTime);
                
            }
        }
                
        
        return sum;
        
    }
    
    private void inform(int id, int[] manager, int[] informTime){
        
        if(id!=-1 && !visited.contains(id)){
            visited.add(id);
            sum+=informTime[id];
            inform(manager[id],manager, informTime);
        }
    }
}