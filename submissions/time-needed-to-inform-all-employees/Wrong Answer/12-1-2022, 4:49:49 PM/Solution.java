// https://leetcode.com/problems/time-needed-to-inform-all-employees

class Solution {
    int sum=0;
    HashSet<Integer> visited = new HashSet<>();
    
    
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
         if(n==1)
             return 0;
    
        
        int sum =inform(-1, manager, informTime, 0);
                
        
        return sum;
        
    }
    
    private int inform(int id, int[] manager, int[] informTime, int curr){
        
        int n = manager.length;
        
        for(int i=0; i<n; i++){
            
            if(manager[i]==id){
                
                curr = Math.max(curr, inform(i, manager, informTime, curr+informTime[i]));
            }
        }
        
        
        return curr;
        
    }
    
    
    /*
    15
0
[-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6]
[1,1,1,1,1,1,1,0,0,0,0,0,0,0,0]
Output
*/
    
}