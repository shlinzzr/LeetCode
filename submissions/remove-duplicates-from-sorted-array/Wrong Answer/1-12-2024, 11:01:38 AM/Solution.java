// https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int idx= 0 ;
        for(int i=1; i<len-1; i++){
            if(nums[i]!=nums[i+1]){
                nums[idx] = nums[i];
                idx++;
                
                if(i==len-2)
                    nums[idx++] = nums[i+1];
            }
            
            
        }
        
        return idx;
    }
}