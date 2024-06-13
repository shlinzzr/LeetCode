// https://leetcode.com/problems/car-fleet

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = speed.length;
       
        
        int fleet = len;
            
        int h = len-1;
        int cost = (target-position[h])/speed[h];
        
        
        
        
        for(int i=len-1; i>=0; i--){
            
            int val = (target-position[i])/speed[i];
            while(val<cost){
                fleet--;
                i--;
                if(i>=0)
                    val = (target-position[i])/speed[i];
                else 
                    break;
            }
            
            cost = val;
        }    
            
        return fleet;
            
        
    }
}