// https://leetcode.com/problems/wiggle-subsequence

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        
        if(len==1)
            return 1;
        else if (len==2 && nums[0]!=nums[1])
            return 2;
        
        Boolean up = null;
        int res =1;
        for(int i=0; i<len-1; i++){
            if(nums[i]==nums[i+1])
                continue;
            
            if(up==null){
                
                if(nums[i]<nums[i+1])
                    up = true;
                else
                    up = false;
                
                res++;
                    
                
            }else if(up ^ nums[i]<nums[i+1]){
                res++;
                up = !up;
                
                
            }
            
        }
        
        
        return res;
        
    }
}