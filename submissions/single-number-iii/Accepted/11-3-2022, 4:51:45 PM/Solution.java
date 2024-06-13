// https://leetcode.com/problems/single-number-iii

class Solution {
    
    
    //bit manipulation : xor & ~(xor-1)
    
    public int[] singleNumber(int[] nums) 
    {
        int xor =0;
        for(int n: nums){
            xor ^= n;
        }
        
        xor = xor & ~(xor-1);
        int n1=0;
        int n2=0;
        
        
        for(int n : nums){
            if((n & xor) >0){
                n1 ^= n;
            }else{
                n2 ^=n;
            }
        }
        
        return new int[]{n1, n2};
        
        
    }
}