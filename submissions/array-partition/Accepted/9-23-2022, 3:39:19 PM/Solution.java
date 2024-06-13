// https://leetcode.com/problems/array-partition

class Solution {
    public int arrayPairSum(int[] nums) {
        // int max = Integer.MIN_VALUE;
        
        Arrays.sort(nums);
        
        int sum =0;
        for(int i=0;i<nums.length; i+=2){
            
            int min = Math.min(nums[i], nums[i+1]);
            sum += min;
            // max = Math.max(max, min);
        }
    
        return sum;
    }
}