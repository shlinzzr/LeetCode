// https://leetcode.com/problems/find-peak-element

class Solution {
    public int findPeakElement(int[] nums) {
        
        int len = nums.length;

        int st=0, ed=len-1;
        while(st<ed){

            int mid = ed-(ed-st)/2;
            if(nums[mid-1]>nums[mid]){
                ed = mid-1;
            }else 
                st =mid;
        }

        return st;
    }
}