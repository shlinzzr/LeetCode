// https://leetcode.com/problems/combination-sum-iv

class Solution {
    
    HashMap<Integer, Integer> map = new HashMap<>();
    
    
    public int combinationSum4(int[] nums, int target) {
      
       int res = dfs(nums, target);
        return res;
    }
    
    
    private int dfs(int[] nums, int target) {
        if(target<0)
            return 0;

        if(target==0)
            return 1;

        if(map.containsKey(target))
            return map.get(target);
        
        
        
        int cnt=0; 
        for(int n: nums){
            cnt+= dfs(nums, target-n);
        }
        map.put(target, cnt);
        
        return cnt;
    }
}