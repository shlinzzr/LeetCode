// https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make

class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        
        int res =1;
        
        for(int c : coins){
            
            if(c<=res){
                res+=c;
            }else{
                break;
            }
        }
        
        return res;
        
        
    }
}