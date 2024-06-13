// https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer

class Solution {
    public int maximumCount(int[] nums) {
        int pos=0, neg=0;
        
        for(int n: nums){
            
            if(n==0)
                continue;
            if(n<0)
                neg++;
            else{
                pos++;
            }
            
        }
        
        return Math.max(pos, neg);
    }
}