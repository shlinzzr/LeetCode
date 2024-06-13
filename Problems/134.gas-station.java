// https://leetcode.com/problems/gas-station

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int len = gas.length;
        int tank = 0 ;
        int res=0;

        int check = 0;
        
        for(int i=0; i<len; i++){

            check += gas[i];
            check -= cost[i];


            tank+= gas[i];
            tank-=cost[i];
            if(tank<0){
                res = i+1;
                tank = 0;
            }
        }

        return check <0 ? -1 : res;
        
    }
}