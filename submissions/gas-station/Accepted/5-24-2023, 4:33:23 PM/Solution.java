// https://leetcode.com/problems/gas-station

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int len = gas.length;
        
        int tank=0;
        
        int idx=0;
        
        int total=0;
        
        for(int i=0; i<len; i++){
            tank+=gas[i]-cost[i];
            total+=gas[i]-cost[i];
            
            if(tank<0){
                idx=i+1;
                tank=0;
                // i=idx;
            }
        }
        
        if(total<0)
            return -1;
        
        
        return idx;
    }
}