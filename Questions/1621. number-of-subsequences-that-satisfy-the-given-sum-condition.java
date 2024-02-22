// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition

class Solution {
    
    public int numSubseq(int[] nums, int target) {
    
        int len = nums.length;
        
        Arrays.sort(nums);

        int res = 0, M = (int) 1e9+7;
        
        
        int[] pow = new int[len];
        pow[0]=1;
        for(int i=1; i<len; i++){
            pow[i] = (pow[i-1]*2)%M;
        }
        
        
        int st=0, ed=len-1;
        while(st<=ed){
            if(nums[st]+nums[ed]>target){
                ed--;
            }else{
                
                res = (res + pow[ed-st])%M;
                st++;
            }
        }
        
        return res;
    }
        
    
}