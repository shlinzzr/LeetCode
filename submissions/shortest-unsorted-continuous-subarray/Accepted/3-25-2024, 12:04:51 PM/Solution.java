// https://leetcode.com/problems/shortest-unsorted-continuous-subarray

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int min = nums[len-1];
        int max= nums[0];
        int st =len-1, ed=0;
        for(int i=1; i<len; i++){
            min = Math.min(min, nums[len-i-1]);
            max = Math.max(max, nums[i]);
            if(nums[len-i-1]>min) st = len-i-1;
            if(nums[i]<max) ed = i;
        }

        return st>=ed ? 0 : ed-st+1;

        
    }
}