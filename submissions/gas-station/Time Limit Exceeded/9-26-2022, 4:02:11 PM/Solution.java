// https://leetcode.com/problems/gas-station

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        for(int st=0; st<gas.length; st++){
            
            int tank =0; 
            
            for(int j=0; j<gas.length; j++){
                int idx = (st+j)%gas.length;
                
                tank += gas[idx];
                
                tank-=cost[idx];

                if(tank<0)
                    break;
                
                
            }
            
            if(tank>=0)
                return st;
                
            
        }
        
        return -1;
    }
}