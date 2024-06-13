// https://leetcode.com/problems/permutations

class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
             
        dfs(nums, 0);
        return res;
        
    }
    
    private void dfs(int[] nums, int len){
        
        if( temp.size() == nums.length ){
            res.add(new ArrayList<>(temp));
        }
                     
        for(int i=0; i<nums.length; i++){
            
            if(!temp.contains(nums[i])) {
                temp.add(nums[i]);
                dfs(nums, len+1);
                temp.remove(temp.size()-1);
             
            }
            
        }
        
        
        
    }
}
