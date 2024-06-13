// https://leetcode.com/problems/single-number-ii

class Solution {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        
        
        
        int res = 0;
        
        for(int i=0; i<32;i++){
            
            int sum =0;    
            for(int n: nums){
                sum+= (n>>i)&1;
            }
            
            res += (sum%3)<<i;
            
            
        }
        
        return res;
        
        
    }
}