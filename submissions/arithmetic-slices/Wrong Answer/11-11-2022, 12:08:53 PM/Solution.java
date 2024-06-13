// https://leetcode.com/problems/arithmetic-slices

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, 0, new ArrayList<>());
        return res.size();
        
    }
    
    private void helper(List<List<Integer>> res, int[] nums, int st, List<Integer> list){
        
        if(list.size()>=3)
            res.add(new ArrayList<>(list));
        
        for(int i=st; i<nums.length; i++){
            
            if(list.isEmpty()){
                list.add(nums[i]);
                helper(res, nums, i+1, list);
            }
            else if(list.get(list.size()-1) +1 == nums[i]){
                list.add(nums[i]);
                helper(res, nums, i+1, list);
                return;
            }else{
                list = new ArrayList<>();
                list.add(nums[i]);
                helper(res, nums, i+1, list);
            }
                
            
        }
        
        
    }
}