// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        backtracking(nums, res, new ArrayList<>());
        
        
        return res;
        
        
        
    }
    
    private void backtracking(int[] nums,  List<List<Integer>> res, List<Integer> list){
        
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                backtracking(nums, res, list);
                list.remove(list.size()-1);
            }
                        
        }
    }
}