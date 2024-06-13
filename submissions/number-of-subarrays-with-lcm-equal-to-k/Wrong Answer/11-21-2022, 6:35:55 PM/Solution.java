// https://leetcode.com/problems/number-of-subarrays-with-lcm-equal-to-k

class Solution {
    
    public int subarrayLCM(int[] nums, int kk) {
        
        int len = nums.length;
        
        int ans =0,n=nums.length;
        for(int i=0; i<len; i++)
        {
            int lcm=1;
            for(int j=i;j<len;j++)
            {
                lcm=getLCM(lcm, nums[j]);
                ans+=(lcm==kk)?1:0;
            }
        }
        return ans;
        
    }
    
    private int getLCM(int a, int b){
        return a*b / getGCD(a,b);
    }
    
    
    private int getGCD(int a, int b){
        if(b==0)
            return a;
        else 
            return getGCD(a, a%b);
    }
}