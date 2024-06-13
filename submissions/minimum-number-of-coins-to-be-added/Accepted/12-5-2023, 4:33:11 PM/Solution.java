// https://leetcode.com/problems/minimum-number-of-coins-to-be-added

class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
       int len = coins.length;

        // https://www.youtube.com/watch?v=f0zzWwclhYQ

        long curr=0;
        int res=0;
        int idx=0;
        // [0, 1)

        while(curr<target){

            if(idx<len && coins[idx]<= curr+1){
                curr+= coins[idx];
                idx++;
            }else{
                res++;
                curr += curr+1;
            }

        }

        return res;
    }
}