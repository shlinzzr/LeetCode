// https://leetcode.com/problems/length-of-the-longest-subsequence-that-sums-to-target

class Solution {
    int max = -1;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        Collections.sort(nums);
        
        
        helper(nums, new ArrayList<>(), target,0);
        
        
        return max;
        
        
    }
    
    
    private void helper(List<Integer> nums, List<Integer> curr, int target, int st){
        if(target<0)
            return ;
        if(target==0){
            max = Math.max(max, curr.size());
            return;
        }
        
        for(int i=st; i<nums.size(); i++){
            if(nums.get(i)>target)
                return;
            
            curr.add(nums.get(i));
            helper(nums, curr, target-nums.get(i), st+1);
            curr.remove(curr.size()-1);
            
        }
    }
}