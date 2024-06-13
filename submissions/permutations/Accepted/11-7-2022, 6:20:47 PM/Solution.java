// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        boolean[] isUsed = new boolean[nums.length];
        
        backtracking(nums, res, new ArrayList<>(), isUsed);
        
        
        return res;
        
        
        
    }
    
    private void backtracking(int[] nums,  List<List<Integer>> res, List<Integer> list, boolean[] isUsed){
        
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(isUsed[i]==false){
                list.add(nums[i]);
                isUsed[i] = true;
                backtracking(nums, res, list, isUsed);
                isUsed[i] = false;
                list.remove(list.size()-1);
            }
                        
        }
    }
}