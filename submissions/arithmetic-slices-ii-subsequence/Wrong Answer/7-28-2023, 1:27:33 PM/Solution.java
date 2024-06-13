// https://leetcode.com/problems/arithmetic-slices-ii-subsequence

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        
        Set<List<Integer>> res = new HashSet<>();
        
        helper(nums, res, new ArrayList<>(), 0);
        
        // System.out.println(res);
        
        return res.size();
        
    }
    
    
    private void helper(int[] nums, Set<List<Integer>> res, List<Integer> curr, int st){
        
        if(curr.size()>=3){
            res.add(new ArrayList<>(curr));
        }
        
        
        for(int i=st; i<nums.length; i++){
            
            int n = nums[i];
            
            if(curr.size()>=2){
                
                if(n-curr.get(curr.size()-1) != curr.get(curr.size()-1)-curr.get(curr.size()-2)) 
                    continue;
                
                curr.add(n);
                helper(nums, res, curr, i+1);
                curr.remove(curr.size()-1);
                
            }else{
                curr.add(n);
                helper(nums, res, curr, i+1);
                curr.remove(curr.size()-1);
                
            }
        }
        
        
        
        
        
    }
}