// https://leetcode.com/problems/length-of-the-longest-subsequence-that-sums-to-target

class Solution {
    int max = 0;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        
        helper(nums, 0, target, 0);
        
        return max==0 ? -1 : max;
    }
    
    private void helper(List<Integer> nums, int idx, int target, int len){
        if(target==0){
            max = Math.max(max, len);
            return;
        }
        if(target<0) return;
        
        for(int i=idx; i<nums.size(); i++){
            if(nums.get(i)<=target){
                helper(nums, i+1, target-nums.get(i), len+1);
            }
        }
    }
}