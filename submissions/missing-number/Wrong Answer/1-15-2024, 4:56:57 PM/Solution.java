// https://leetcode.com/problems/missing-number

class Solution {
    public int missingNumber(int[] nums) {
        
        int len = nums.length;
        
        for(int i=0; i<len; i++){
            
            while(nums[i]<len && nums[i]!= i && nums[nums[i]]!=nums[i]){               
                swap(nums, i, nums[i]);
            }
        }
        
        for(int i=0; i<len; i++){
            if(nums[i]!=i) return i;
        }
        
        
        return -1;
        
    }
    
    private void swap(int[] nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
    
    
}