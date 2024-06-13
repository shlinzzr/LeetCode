// https://leetcode.com/problems/wiggle-sort-ii

class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        
        int idx =2;
        
        for(int i=1; i<len; i++){
            
            while(idx<len-1 && nums[idx]<=nums[i])
                idx++;
            
            int tmp = nums[i];
            nums[i] = nums[idx];
            nums[idx]=tmp;
            i++;
        }
    }
    
//     1 1 1 4 5 6 
        
//     1 4 1 1 5 6
//       ^   ^
}