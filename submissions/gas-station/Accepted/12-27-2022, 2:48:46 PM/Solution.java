// https://leetcode.com/problems/gas-station

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] minus = new int[len];
        
        int max = 0;
        int gasSum = 0, costSum=0;
        for(int i=0; i<len; i++){
            gasSum+=gas[i];
            costSum+=cost[i];
            if(gas[i]>cost[i]){
                max = Math.max(max, gas[i]-cost[i]);
            }
        }
        
        
        if(gasSum<costSum)
            return -1;
        
        
        int tank = 0;
        int start=0;
        
        for(int i=0; i<len; i++){
            
            tank += gas[i]-cost[i];
            if(tank<0){
                tank=0;
                start = i+1;
                    
            }
        }
        
        return start;
    }
}