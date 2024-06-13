// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] seen = new boolean[nums.length];
        
        helper(res, nums, new ArrayList<>(), seen);
        return res;
    }
    
    private void helper(List<List<Integer>> res , int[] nums, List<Integer> list, boolean[] seen){
        
        if(list.size()==nums.length)
            res.add(new ArrayList<>(list));
        
        for(int i=0; i<nums.length; i++){
            
            if(seen[i]==false){
                seen[i]=true;
                list.add(nums[i]);
                
                helper(res, nums, list, seen);
                seen[i]=false;
                list.remove(list.size()-1);
            }
            
        }
        
        
    }
}