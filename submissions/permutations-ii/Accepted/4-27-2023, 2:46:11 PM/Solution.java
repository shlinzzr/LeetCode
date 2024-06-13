// https://leetcode.com/problems/permutations-ii

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res= new HashSet<>();
        int len = nums.length;
             Arrays.sort(nums);
         boolean[] seen = new boolean[nums.length];
        
        
        helper(nums, new ArrayList<>(), seen,  res);
            
        return new ArrayList<>(res);
        
    }
    
    private void helper(int[] nums, List<Integer> list, boolean[] seen ,  Set<List<Integer>> res){
        
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        
        

            
        
        
        for(int i=0; i<nums.length; i++){
            
            
            if(i>0 && nums[i-1]==nums[i] && seen[i-1]==false)
               continue;
            
            if(!seen[i]){
                list.add(nums[i]);
                seen[i]=true;
                helper(nums, list, seen, res);
                list.remove(list.size()-1);
                seen[i]=false;
            }
            
        }
        
        
    }
        
        
}