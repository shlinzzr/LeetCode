// https://leetcode.com/problems/array-partition

class Solution {
    public int arrayPairSum(int[] nums) {
        
        int len = nums.length;
        Arrays.sort(nums);
        
        int sum = 0 ;
        
        int max = 0;
        for(int i=0;i<len; i+=2){
            int a = nums[i];
            int b = nums[i+1];
            
            sum += Math.min(a,b);
            // max = Math.max(max,Math.min(a,b));
        }
        
        return sum;
        
        
        
    }
}