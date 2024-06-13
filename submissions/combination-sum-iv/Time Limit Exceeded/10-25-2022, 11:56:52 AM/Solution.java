// https://leetcode.com/problems/combination-sum-iv

class Solution {
    
    int cnt = 0;
    HashMap<Integer, Integer> map;
    public int combinationSum4(int[] nums, int target) {
        map = new HashMap<>();
        
        dfs(nums, target);
        
        return cnt;
    }
    
    
    private int dfs(int[] nums, int target){
     
        if(target<0)
            return 0;
        
        if(target==0){
            cnt++;
            return 1;
        }
        
        int res = 0;
        for(int n : nums){
            
            int k = dfs(nums, target-n);
            map.put(target-n, k);
            res+=k;
            
        }
        map.put(target, res);
        return res;        
    }
}