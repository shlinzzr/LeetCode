// https://leetcode.com/problems/wiggle-sort

class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        
        Arrays.sort(nums);
        if(len<=2)
            return;
        
            
        for(int i=1;i<len&&i+1<len; i+=2){
            
            int tmp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = tmp;
        }
        
        
        
        
        
        
    }
}