// https://leetcode.com/problems/permutations-ii

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        
        Set<List<Integer>> set = new HashSet<>();
        backtrack(set, nums, new ArrayList<>(), used, 0);
        
        
        return new ArrayList<>(set);
    }
    
    private void backtrack(Set<List<Integer>> res, int[] nums, List<Integer> list, boolean[] used, int start){
        
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
        }
        
        for(int i=0; i<nums.length; i++){
            
            if(used[i]==false){
                
                list.add(nums[i]);
                used[i]=true;
                backtrack(res, nums, list, used, start);
                used[i]=false;
                list.remove(list.size()-1);
                
            }
                
            
        }
        
    }
    
    
}