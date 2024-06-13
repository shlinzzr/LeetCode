// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii

class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        
        int st=0;
        int ed = len-1;
        
        while(st<ed){
            int mid = st+(ed-st)/2;
            
            if(nums[mid]>nums[ed]){
                
                st = mid +1;
            }else{
                ed= mid;
            }
        }
        
        return nums[st];
    }
}