// https://leetcode.com/problems/gas-station

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int len = gas.length;
        int total =0;
        
        int tank=0;
        int start=0;
        for(int i=0; i<len; i++){

            total += gas[i]-cost[i];
            tank += gas[i]-cost[i];
            if(tank<0){
                tank=0;
                start=i+1;
            }
        }
        
        if(total<0)
            return -1;
        
        return start;
        
    }
}