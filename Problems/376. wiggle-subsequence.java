// https://leetcode.com/problems/wiggle-subsequence

class Solution {
    public int wiggleMaxLength(int[] nums) {
        
        
        if(nums.length==1)
            return 1;
        if(nums.length==2 && nums[0]!=nums[1]){
            return 2;
        }
            
        int ans = 1;
        Boolean isUp = null;
        for(int i=0; i< nums.length-1; i++){
            if(nums[i]==nums[i+1])
                continue;
            
            if(isUp==null){
                isUp = nums[i]<nums[i+1] ? true : false;
                ans++;
            }else if( isUp ^ (nums[i]<nums[i+1]) ){
                
                ans++;
                isUp = !isUp;
            }
        }
        
        return ans;
        
    }
}