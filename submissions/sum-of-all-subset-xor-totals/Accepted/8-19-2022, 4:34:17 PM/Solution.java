// https://leetcode.com/problems/sum-of-all-subset-xor-totals

class Solution {
    int total = 0;
    
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        backtracking(nums, res, new ArrayList<>(), 0);
        
        
        for(List<Integer> list : res){
            int cur = 0;
            for(int i : list){
                cur ^= i;
            }
             total+=cur;
            
        }
        
        
        return total;
        
    }
    
    private void backtracking(int[] nums, List<List<Integer>> res , List<Integer> list, int start){
        res.add(new ArrayList<>(list));
        
        for(int i=start; i<nums.length; i++){
            
            list.add(nums[i]);
            backtracking(nums,res ,list, i+1);
            list.remove(list.size()-1);
        }
        
        
    }
   
    
}