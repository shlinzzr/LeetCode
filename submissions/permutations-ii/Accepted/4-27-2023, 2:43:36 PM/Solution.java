// https://leetcode.com/problems/permutations-ii

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res= new HashSet<>();
        int len = nums.length;
        helper(nums, new ArrayList<>(), new HashSet<>(),  res);
            
        return new ArrayList<>(res);
        
    }
    
    private void helper(int[] nums, List<Integer> list, Set<Integer> set,  Set<List<Integer>> res){
        
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        
        
        for(int i=0; i<nums.length; i++){
            
            if(!set.contains(i)){
                list.add(nums[i]);
                set.add(i);
                helper(nums, list, set, res);
                list.remove(list.size()-1);
                set.remove(i);
            }
            
        }
        
        
    }
        
        
}