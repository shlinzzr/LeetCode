// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves

class Solution {
    public int minDifference(int[] nums) {
        
        int len = nums.length;
        
        if(len<=4)
            return 0;
            
        
        Arrays.sort(nums);
        
        
        return nums[len-4]- nums[0];
        
        
    }
}