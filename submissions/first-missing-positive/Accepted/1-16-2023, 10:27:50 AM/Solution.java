// https://leetcode.com/problems/first-missing-positive

class Solution {
    public int firstMissingPositive(int[] nums) {
        int len =  nums.length;
        
        
        for(int i=0; i<len; i++){
            
            while( nums[i]-1!=i && nums[i]-1>=0 && nums[i]-1<len && nums[i]!=nums[nums[i]-1]){
              
                
                swap(nums, i, nums[i]-1);
                
            }
            
        }
        
        for(int i=0; i<len;i++){
            if(nums[i]-1!=i)
                return i+1;
        }
        
        return len+1;
    }
    
     private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;    
    }
    
}