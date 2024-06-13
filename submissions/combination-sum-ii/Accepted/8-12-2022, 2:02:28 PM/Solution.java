// https://leetcode.com/problems/combination-sum-ii

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(candidates); // 1, 1, 2, 5, 6, 7, 10
        
        boolean[] used = new boolean[candidates.length];
        helper(res, candidates, target, new ArrayList<>(), 0, used);
        
        return res;
        
    }
    
    
    private void helper(List<List<Integer>> res, int[] nums, int target, List<Integer> list, int start, boolean[] used){
        
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=start; i<nums.length; i++){
            
            if(used[i]==true || target-nums[i]<0)
                continue;
            
            if(i>0 && nums[i-1]==nums[i] && used[i-1]==false)
                continue;
                
            list.add(nums[i]);
            used[i]=true;
            helper(res, nums, target-nums[i], list, i+1, used);
            list.remove(list.size()-1);
            used[i]=false;
            
        }
        
        
        
        
    }
        
}