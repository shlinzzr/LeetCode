// https://leetcode.com/problems/rotate-array

class Solution {
    public void rotate(int[] nums, int k) {
        
        
        

        for(int j=0; j<k%nums.length; j++){
            int tmp = nums[0];
            for(int i=nums.length-1; i>=0;i--){
                nums[(i+1)%nums.length] = nums[i%nums.length];
            }
            nums[1] = tmp;    
        }
        
        
    }
}