// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int len = nums.length;
        
        for(int i=0; i<len; i++){
            
            int idx =-1;
            
            if(nums[i]<0){
                idx = -nums[i]-1;
            }else{
                 idx = nums[i]-1;
            }
            
            if(nums[idx]>0)
            
                nums[idx] = -nums[idx];
        }
                
//          for(int n : nums){
//              System.out.println(n);
//          }
        
        
    
        List<Integer> res = new ArrayList<>();
    
        for(int i=0; i<len; i++){
            if(nums[i]>0)
                res.add(i+1);
        }
            
        return res;
        
        
    }
}