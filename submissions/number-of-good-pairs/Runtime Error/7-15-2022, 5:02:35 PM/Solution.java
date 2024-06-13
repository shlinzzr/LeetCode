// https://leetcode.com/problems/number-of-good-pairs

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] digits = new int[100];
        
        for(int n: nums){
            digits[n]++;
        }
        
        int total = 0;
        for(int d : digits){
            
            if(d!=0){
                total += d*(d-1) / 2;
                
                
            }
            
        }
        
        return total;
        
    }
}