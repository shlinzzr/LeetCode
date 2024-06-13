// https://leetcode.com/problems/length-of-the-longest-subsequence-that-sums-to-target

class Solution {
    int max = -1;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        Collections.sort(nums);
        
//         int[][] dp = new int[nums.size()+1][target]; // 用i個數字達成target 的最長長度
//         // Arrays.fill(dp, -1);
//         for(int i=1; i<=nums.size(); i++){
//             int n = nums.get(i-1);
//             if(dp[i-1][])
//             if(n<target){
//                 dp[i][]
//             }
//         }
        
        
        helper(nums, new ArrayList<>(), target, 0);
        
        
        return max;
        
        
    }
    
    // TLE
    private void helper(List<Integer> nums, List<Integer> curr, int target, int st){
        
        if(max!=-1)
            return;
        
        if(target<0)
            return;
        
        if(target==0){
            max = Math.max(max, curr.size());
            return;
        }
        
        for(int i=st; i<nums.size(); i++){
            if(nums.get(i)>target)
                return;
            
            curr.add(nums.get(i));
            helper(nums, curr, target-nums.get(i), i+1);
            curr.remove(curr.size()-1);
            
        }
    }
}