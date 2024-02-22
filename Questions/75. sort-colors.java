// https://leetcode.com/problems/sort-colors

class Solution {
    public void sortColors(int[] nums) {
        
        int z= 0;
        int o=0;
        int t=0;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0) z++;
            if(nums[i]==1) o++;
            if(nums[i]==2) t++;
        }
        
        for(int i=0; i<nums.length; i++){
            if(z-->0) nums[i]=0;
            else if(o-->0) nums[i] = 1;
            else if(t-->0) nums[i] = 2;
        }
        
        
        
        
            
        
        
    }
}