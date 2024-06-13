// https://leetcode.com/problems/subsets-ii

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        boolean[] used = new boolean[nums.length];
        helper(nums, res, new ArrayList<>(), used, 0);
        return res;
        
    }
    
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] used , int start){
        
        res.add(new ArrayList<>(list));
        
        for(int i=start; i<nums.length; i++){
            if(i>0 && nums[i-1]==nums[i] && used[i-1]==false)
                continue;
            
            list.add(nums[i]);
            used[i]=true;
            helper(nums, res, list, used, i+1);
            list.remove(list.size()-1);
            used[i]=false;
            
            
        }
        
        
    }
}