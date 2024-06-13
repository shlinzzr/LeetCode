// https://leetcode.com/problems/increasing-triplet-subsequence

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        
        int[] leftMin = new int[len];
        int[] rightMax = new int[len];
        
        for(int i=0; i<len; i++){
            leftMin[i] = i==0  ? nums[0] : Math.min(leftMin[i-1], nums[i]);
        }        
        
        for(int i=len-1; i>=0; i--){
            rightMax[i] = i==len-1 ? nums[len-1] : Math.max(rightMax[i+1], nums[i]);   
        }
        
        for(int i=0; i<len; i++){
            if(leftMin[i]<nums[i] && nums[i]<rightMax[i])
                return true;
        }
        
        return false;
        
    }
}