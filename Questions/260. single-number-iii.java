// https://leetcode.com/problems/single-number-iii

class Solution {
    
    
    //bit manipulation : xor & ~(xor-1)
    
    public int[] singleNumber(int[] nums) 
    {
        int xor =0;
        for(int n: nums){
            xor ^= n;
        }
        
        int bit = xor & ~(xor-1);
        int num1 = 0;
        int num2 = 0;

        for (int num : nums)
        {
            if ((num & bit) > 0)
            {
                num1 ^= num;
            }
            else
            {
                num2 ^= num;
            }
        }
        
        return new int[]{num1, num2};
        
        
    }
}