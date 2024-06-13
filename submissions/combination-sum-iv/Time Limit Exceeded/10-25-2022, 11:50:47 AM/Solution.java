// https://leetcode.com/problems/combination-sum-iv

class Solution {
    
    int cnt = 0;
    
    public int combinationSum4(int[] nums, int target) {
        dfs(nums, target);
        return cnt;
    }
    
    
    private void dfs(int[] nums, int target){
     
        if(target<0)
            return;
        
        if(target==0){
            cnt++;
            return;
        }
        
        for(int n : nums){
            
            dfs(nums, target-n);
            
        }
            
        
        
        
    }
}