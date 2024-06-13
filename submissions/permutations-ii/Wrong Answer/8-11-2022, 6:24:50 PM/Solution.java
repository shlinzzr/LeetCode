// https://leetcode.com/problems/permutations-ii

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, new ArrayList<>(), used);
        
        
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> list, boolean[] used){
        
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
        }
        
        for(int i=0; i<nums.length; i++){
            
            if(used[i])
                continue;
            
            if(i>0 && nums[i-1]==nums[i] && used[i-1]==false)
               continue;
            
            list.add(nums[i]);
            used[i]=true;
            backtrack(res, nums, list, used);
            used[i]=false;
            list.remove(list.size()-1);
                
                
            
        }
        
    }
    
    
}