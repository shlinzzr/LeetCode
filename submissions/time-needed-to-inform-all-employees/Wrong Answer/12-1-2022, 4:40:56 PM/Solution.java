// https://leetcode.com/problems/time-needed-to-inform-all-employees

class Solution {
    int sum=0;
    HashSet<Integer> visited = new HashSet<>();
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
         if(n==1)
             return 0;
    
        
        for(int i=0; i<n; i++){
            
            int id = manager[i];
            
            
            if(!visited.contains(id)){
               
                inform(id, manager, informTime);
                
            }
        }
                
        
        return sum;
        
    }
    
    private void inform(int id, int[] manager, int[] informTime){
        
        if(id!=-1 && !visited.contains(id)){
            System.out.println(id);
            visited.add(id);
            sum+=informTime[id];
            inform(manager[id],manager, informTime);
        }
    }
    
    
    /*
    15
0
[-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6]
[1,1,1,1,1,1,1,0,0,0,0,0,0,0,0]
Output
*/
    
}