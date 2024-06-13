// https://leetcode.com/problems/sorting-three-groups

class Solution {
    public int minimumOperations(List<Integer> nums) {
        // nums = [2,1,3,2,1]
        // 1 : 1 4 0 2 3
        // 2 : 
        // 3 : 
      
        
        // 3 1 2 => 1 3 2 => 1 2 3
        
        int len = nums.size();
      
        int res = 0;
        for(int i=0; i<len-1; i++){
            
            if(nums.get(i)>nums.get(i+1))
                res++;
            
        }
        
        
        return res;
        
            
            
        
        
    }
}