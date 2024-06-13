// https://leetcode.com/problems/missing-element-in-sorted-array

class Solution {
    public int missingElement(int[] nums, int k) {
        int len = nums.length; 
        
        int curr = nums[0];
        int idx = 1;
        
        while(k>0){
            
            if(idx<len){
                
                if(nums[idx]==curr+1){
                    idx++;
                    curr++;
                    
                }else{
                    k--;
                    curr++;
                }
            }else{
                k--;
                curr++;
                
            }
        }
        
         return curr;
    }
}