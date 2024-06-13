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
        
        for(int i=0; i<len; i++){
            if(gas[i]-cost[i]==max)
                return i;
        }
        
        return -1;
    }
}